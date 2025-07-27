package com.CommunityVolunteerPlatform.project.Services;



// service/TaskSignupService.java


import com.CommunityVolunteerPlatform.project.Entity.TaskSignup;
import com.CommunityVolunteerPlatform.project.Repositories.TaskSignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskSignupService {

    @Autowired
    private TaskSignupRepository signupRepository;

    @Autowired
    private EmailServiceForScheduling emailService;

    public void register(TaskSignup signup) {
        signupRepository.save(signup);
        emailService.sendConfirmationEmail(signup.getEmail(), signup.getName(), signup.getTaskName());
    }

    public List<TaskSignup> getAllSignups() {
        return signupRepository.findAll();
    }

    public void sendReminderEmail(String to, String name, String task, LocalDate date) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Reminder: Upcoming Volunteer Task");
        message.setText("Hi " + name + ",\n\nThis is a friendly reminder that your task '" + task +
                "' is scheduled for tomorrow (" + date + ").\n\nPlease be on time!\n\nThank you.");
        emailService.sendReminderEmail(message);
    }

    public List<TaskSignup> getSignupsForTomorrow() {
        LocalDate tomorrow = LocalDate.now().plusDays(1);
        return signupRepository.findAll().stream()
                .filter(signup -> tomorrow.equals(signup.getTaskDate()))
                .toList();
    }
}