package com.CommunityVolunteerPlatform.project.Entity;



import jakarta.persistence.*;

@Entity
public class VolunteerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phone;
    private String skills;
    private String address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    // No-args constructor
    public VolunteerProfile() {
    }

    // All-args constructor
    public VolunteerProfile(Long id, String phone, String skills, String address, User user) {
        this.id = id;
        this.phone = phone;
        this.skills = skills;
        this.address = address;
        this.user = user;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
