package com.anuscode.user;

import java.time.LocalDate;
import java.util.Objects;

public class User {

    private Long id;
    private String title;
    private String description;
    private String taskType;
    private LocalDate dueDate;
    private boolean isCompleted;

    //Constructors
    public User(){
    }

    public User(Long id, String title, String description, String taskType, LocalDate dueDate, boolean isCompleted){
        this.id = id;
        this.title = title;
        this.description=description;
        this.taskType = taskType;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
    }

    //Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getTaskType() {
        return taskType;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    //Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isCompleted == user.isCompleted && Objects.equals(id, user.id) && Objects.equals(title, user.title) && Objects.equals(description, user.description) && Objects.equals(taskType, user.taskType) && Objects.equals(dueDate, user.dueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, taskType, dueDate, isCompleted);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", taskType='" + taskType + '\'' +
                ", dueDate=" + dueDate +
                ", isCompleted=" + isCompleted +
                '}';
    }
}
