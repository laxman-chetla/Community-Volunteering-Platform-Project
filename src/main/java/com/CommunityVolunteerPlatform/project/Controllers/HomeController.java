package com.CommunityVolunteerPlatform.project.Controllers;




// === HomeController.java ===


import com.CommunityVolunteerPlatform.project.Entity.User;
import com.CommunityVolunteerPlatform.project.Repositories.UserRepository;
import com.CommunityVolunteerPlatform.project.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }



    @GetMapping("/delete-account")
    public String deleteAccount(Principal principal) {
        String email = principal.getName();
        User user = userRepository.findByEmail(email);

        if (user != null) {
            userRepository.delete(user);
            SecurityContextHolder.clearContext();
        }

        return "redirect:/login?deleted=true"; // Will go to login page
    }
    @GetMapping("/cvp")
    public String index() {
        return "HomeBeforeLogin";
    }

}
