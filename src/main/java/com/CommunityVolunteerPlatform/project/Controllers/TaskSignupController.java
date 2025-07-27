package com.CommunityVolunteerPlatform.project.Controllers;

// controller/TaskSignupController.java

import com.CommunityVolunteerPlatform.project.Entity.TaskSignup;
import com.CommunityVolunteerPlatform.project.Services.TaskSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/signup")
public class TaskSignupController {

    @Autowired
    private TaskSignupService signupService;

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("taskSignup", new TaskSignup());
        return "signup_form";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute TaskSignup taskSignup, Model model) {
        signupService.register(taskSignup);
        model.addAttribute("message", "Registration successful! A confirmation email has been sent.");
        return "signup_form";
    }

    @GetMapping("/view")
    public String viewSignups(Model model) {
        List<TaskSignup> list = signupService.getAllSignups();
        model.addAttribute("signups", list);
        return "view_signups";
    }
}