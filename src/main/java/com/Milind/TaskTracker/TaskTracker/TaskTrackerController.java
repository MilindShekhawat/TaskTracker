package com.Milind.TaskTracker.TaskTracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping({"tasks"})          //Controller Class responsible for making HTTP requests
public class TaskTrackerController {

    private final TaskTrackerService taskTrackerService;
    @Autowired
    public TaskTrackerController(TaskTrackerService taskTrackerService) {
        this.taskTrackerService = taskTrackerService;
    }

    //Calling TaskTrackerService, All the mapping functionality is in TaskTrackerService
    //Respective methods are called
    @GetMapping
    public List<TaskTracker> getAllTasks() {
        return taskTrackerService.getTask(null);
    }

    @GetMapping("{id}")
    public List<TaskTracker> getTaskById(@PathVariable String id) {
        return taskTrackerService.getTask(id);
    }

    @PostMapping
    public void postTask(@RequestBody TaskTracker taskTracker){
        taskTrackerService.addTask(taskTracker);
    }

    @DeleteMapping("{id}")
    public void deleteTask(@PathVariable("id") String id) {
        taskTrackerService.removeTask(id);
    }

    @PutMapping("{id}")
    public void putTask(@PathVariable("id") String id,
                        @RequestParam(required = false) String title,
                        @RequestParam(required = false) String description,
                        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate due_date){
        taskTrackerService.updateTask(id, title, description, due_date);
    }
}
