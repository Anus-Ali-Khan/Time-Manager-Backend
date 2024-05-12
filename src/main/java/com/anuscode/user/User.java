package com.anuscode.user;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

@Entity  // Connect to JPA (Hibernate)
@Table(name = "users")  // Generate tables in database
public class User {

    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String title;
    private String description;
    private String taskType;
    private LocalDate dueDate;
    private boolean isCompleted;
    private LocalDate dob;
    @Transient // it will indicate that age will not be part of our database but calculated by upper variables
    private Integer age;

    //Constructors
    public User(){
    }

    public User(Long id, String title, String description, String taskType, LocalDate dueDate, boolean isCompleted, LocalDate dob){
        this.id = id;
        this.title = title;
        this.description=description;
        this.taskType = taskType;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        this.dob = dob;
    }

    public User( String title, String description, String taskType, LocalDate dueDate, boolean isCompleted, LocalDate dob){
        this.title = title;
        this.description=description;
        this.taskType = taskType;
        this.dueDate = dueDate;
        this.isCompleted = isCompleted;
        this.dob = dob;
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

    public LocalDate dob(){
       return dob;
    }

    public Integer getAge(){
        return Period.between(this.dob,LocalDate.now()).getYears();
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

    public void dob(LocalDate dob){
        this.dob = dob;
    }

    public void setAge(Integer age){
        this.age = age;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isCompleted == user.isCompleted && Objects.equals(id, user.id) && Objects.equals(title, user.title) && Objects.equals(description, user.description) && Objects.equals(taskType, user.taskType) && Objects.equals(dueDate, user.dueDate) && Objects.equals(dob, user.dob) && Objects.equals(age, user.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, taskType, dueDate, isCompleted, dob, age);
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
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}
