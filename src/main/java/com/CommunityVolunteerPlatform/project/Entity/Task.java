package com.CommunityVolunteerPlatform.project.Entity;



import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String location;
    private String skills;
    private LocalDate date;
    private String time;
     // false = available, true = already signed up

    // Getters and Setters
    // (Generate via IDE)

    public Task() {
    }

    public Task(Long id, String title, String description, String location, String skills, LocalDate date, String time) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.skills = skills;
        this.date = date;
        this.time = time;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}