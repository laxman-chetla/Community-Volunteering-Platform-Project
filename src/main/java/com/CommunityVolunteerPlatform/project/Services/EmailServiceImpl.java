package com.CommunityVolunteerPlatform.project.Services;
//using the mimemessage and the java mail sender to send the OTP to the user and html page to the user


import java.nio.file.Files;
import java.nio.file.Paths;


import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendOtp(String to, String otp) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject("Community Volunteering Platform - OTP Verification");

            // Load HTML from file located in src/main/resources/emailTemplate.html
            ClassPathResource resource = new ClassPathResource("templates/EmailTemplate.html");
            String htmlContent = new String(Files.readAllBytes(Paths.get(resource.getURI())), "UTF-8");

            // Replace placeholder with otp
            htmlContent = htmlContent.replace("${otp}", otp);

            helper.setText(htmlContent, true);

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}











/*

//below used the simple mail service to send the OTP to the user that is also correct you can use this code if you want to use the simple mail service

package com.LoginApi.CVP.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendOtp(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("OTP Verification");
        message.setText("Your OTP is: " + otp);
        mailSender.send(message);
    }
}



 */