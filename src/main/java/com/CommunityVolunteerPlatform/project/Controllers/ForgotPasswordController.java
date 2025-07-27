package com.CommunityVolunteerPlatform.project.Controllers;



import com.CommunityVolunteerPlatform.project.Entity.User;
import com.CommunityVolunteerPlatform.project.Repositories.UserRepository;
import com.CommunityVolunteerPlatform.project.Services.EmailService;
import com.CommunityVolunteerPlatform.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class ForgotPasswordController {

    @Autowired
    private EmailService emailService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/forgot-password")
    public String showForgotForm() {
        return "forgot_password";
    }

    @PostMapping("/forgot-password")
    public String processForgot(@RequestParam String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            String otp = UUID.randomUUID().toString().substring(0, 6);
            user.setOtp(otp);
            userRepository.save(user);
            emailService.sendOtp(email, otp);
        }
        return "redirect:/reset-password?email=" + email;
    }

    @GetMapping("/reset-password")
    public String showResetForm(@RequestParam String email, Model model) {
        model.addAttribute("email", email);
        return "reset_password";
    }

    @PostMapping("/reset-password")
    public String processReset(@RequestParam String email, @RequestParam String otp, @RequestParam String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getOtp().equals(otp)) {
            userService.resetPassword(email, password);
            return "redirect:/login";
        }
        return "reset_password";
    }
}
