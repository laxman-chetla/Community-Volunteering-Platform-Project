package com.CommunityVolunteerPlatform.project.Entity;


import jakarta.persistence.*;

@Entity
public class OrganizationProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gstNumber;
    private String location;
    private String website;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // No-args constructor
    public OrganizationProfile() {
    }

    // All-args constructor
    public OrganizationProfile(Long id, String gstNumber, String location, String website, User user) {
        this.id = id;
        this.gstNumber = gstNumber;
        this.location = location;
        this.website = website;
        this.user = user;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGstNumber() {
        return gstNumber;
    }

    public void setGstNumber(String gstNumber) {
        this.gstNumber = gstNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
