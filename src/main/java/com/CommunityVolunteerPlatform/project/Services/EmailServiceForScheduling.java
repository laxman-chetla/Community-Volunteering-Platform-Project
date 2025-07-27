package com.CommunityVolunteerPlatform.project.Services;



// service/EmailService.java


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class EmailServiceForScheduling {

    @Autowired
    private JavaMailSender mailSender;

    public void sendConfirmationEmail(String to, String name, String task) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Task Signup Confirmation");
        message.setText("Hi " + name + ",\n\nYou have successfully signed up for the task: " + task + ".\n\nThank you!");

        mailSender.send(message);
    }

    public void sendReminderEmail(String to, String name, String task, LocalDate date) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Reminder: Upcoming Volunteer Task");
        message.setText("Hi " + name + ",\n\nThis is a friendly reminder that your task '" + task +
                "' is scheduled for tomorrow (" + date + ").\n\nPlease be on time!\n\nThank you.");
        mailSender.send(message);
    }

    public void sendReminderEmail(SimpleMailMessage message) {

    }
}