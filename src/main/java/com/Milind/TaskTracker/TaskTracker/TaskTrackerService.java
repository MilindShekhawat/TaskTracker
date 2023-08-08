package com.Milind.TaskTracker.TaskTracker;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Service
public class TaskTrackerService {

    private final TaskTrackerRepository taskTrackerRepository;
    @Autowired
    public TaskTrackerService(TaskTrackerRepository taskTrackerRepository) {    //TaskTrackerRepository extends JPA Repository
        this.taskTrackerRepository = taskTrackerRepository;
    }

    public List<TaskTracker> getTask(String id){        //getTask processes the GET requests
        //Processes vanilla GET requests
        if(id == null){
            return taskTrackerRepository.findAll();
        }

        //Processes parameterised GET requests
        else{
            TaskTracker taskTracker = taskTrackerRepository.findById(id).orElseThrow(() ->
                    new IllegalStateException("Task " + id + " does not exist."));

            return Collections.singletonList(taskTracker);
        }
    }

    public void addTask(TaskTracker taskTracker){   //addTask processes POST requests
        String id = taskTracker.getId();
        String title = taskTracker.getTitle();
        String description = taskTracker.getDescription();
        LocalDate due_Date = taskTracker.getDueDate();

        //Throw exception if id already exists
        boolean exist = taskTrackerRepository.existsById(id);
        if(exist)   throw new IllegalStateException("Task " + id + " already exists.");

        validateData(id, title, description, due_Date);
        taskTrackerRepository.save(taskTracker);
    }

    public void removeTask(String id) {     //removeTask processes DELETE requests
        //Throw exception if id doesn't exist
        boolean exist = taskTrackerRepository.existsById(id);
        if(!exist)  throw new IllegalStateException("Task " + id + " does not exist.");

        taskTrackerRepository.deleteById(id);
    }

    @Transactional
    public void  updateTask(String id, String  title, String  description, LocalDate due_date){     //updateTask processes PUT requests

        TaskTracker taskTracker = taskTrackerRepository.findById(id).orElseThrow(() ->
                new IllegalStateException("Task " + id + " does not exist."));

        validateData(id, title, description, due_date);

        if (title != null && title.length() > 0 && title.length() <= 255) {
            taskTracker.setTitle(title);
        }

        if (description != null && description.length() > 0 && description.length() <= 255) {
            taskTracker.setDescription(description);
        }

        if(due_date != null){
            taskTracker.setDueDate(due_date);
        }
    }

    private void validateData(String id, String title, String description, LocalDate due_date) {    //Throws exceptions if input data doesn't align with schema rules
        String idPattern = "T\\d+";

        if (id == null || !id.matches(idPattern)) {
            throw new IllegalArgumentException("Invalid ID format: " + id + ". Please use ids Like T1, T2, etc.");
        }

        if (title != null && title.length() > 255) {
            throw new IllegalArgumentException("Title length exceeds 255 characters.");
        }

        if (description != null && description.length() > 255) {
            throw new IllegalArgumentException("Description length exceeds 255 characters.");
        }
    }
}
