package com.Milind.TaskTracker.TaskTracker;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class TaskTracker {
    //Variables
    @Id
    private String id;
    private String title;
    private String description;
    private LocalDate due_date;

    //Constructors
    public TaskTracker(String id, String title, String description, LocalDate due_date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.due_date = due_date;
    }

    public TaskTracker() {
    }

    //Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return due_date;
    }

    public void setDueDate(LocalDate due_date) {
        this.due_date = due_date;
    }

    @Override
    public String toString() {
        return "TaskTracker{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", due_date=" + due_date +
                '}';
    }
}
