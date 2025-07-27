package com.CommunityVolunteerPlatform.project.Entity;



// scheduler/ReminderScheduler.java




import com.CommunityVolunteerPlatform.project.Services.EmailServiceForScheduling;
import com.CommunityVolunteerPlatform.project.Services.TaskSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ReminderScheduler {

    @Autowired
    private TaskSignupService signupService;

    @Autowired
    private EmailServiceForScheduling emailServiceForScheduling;
    //Note for minute every minute or for every day 8:00 am just comment either of them acc to your convenience
    @Scheduled(cron = "0 0 8 * * ?") // Every day at 8 AM
    // @Scheduled(fixedRate= 60000)
    public void sendReminders() {
        List<TaskSignup> upcoming = signupService.getSignupsForTomorrow();
        for (TaskSignup signup : upcoming) {
            emailServiceForScheduling.sendReminderEmail(
                    signup.getEmail(),
                    signup.getName(),
                    signup.getTaskName(),
                    signup.getTaskDate()
            );
        }
    }
}