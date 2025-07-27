package com.CommunityVolunteerPlatform.project.Entity;

// model/TaskSignup.java


import jakarta.persistence.*;

import java.time.LocalDate;


@Entity

public class TaskSignup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String taskName;
    private String contactNumber;
    private String email;
    private LocalDate taskDate;

    public TaskSignup(Long id, String name, String taskName, String contactNumber, String email, LocalDate taskDate) {
        this.id = id;
        this.name = name;
        this.taskName = taskName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.taskDate = taskDate;
    }

    public TaskSignup() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }
}