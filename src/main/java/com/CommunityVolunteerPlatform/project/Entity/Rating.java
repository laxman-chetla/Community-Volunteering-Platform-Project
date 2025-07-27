package com.CommunityVolunteerPlatform.project.Entity;



import jakarta.persistence.*;

import java.time.LocalDate;

@Entity

public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String volunteerName;
    private String organizationName;
    private int stars;

    @Column(length = 1000)
    private String comment;

    private LocalDate date;

    public Rating() {
    }

    public Rating(Long id, String volunteerName, String organizationName, int stars, String comment, LocalDate date) {
        this.id = id;
        this.volunteerName = volunteerName;
        this.organizationName = organizationName;
        this.stars = stars;
        this.comment = comment;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}