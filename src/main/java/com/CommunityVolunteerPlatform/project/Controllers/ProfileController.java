package com.CommunityVolunteerPlatform.project.Controllers;

import com.CommunityVolunteerPlatform.project.Entity.OrganizationProfile;
import com.CommunityVolunteerPlatform.project.Entity.User;
import com.CommunityVolunteerPlatform.project.Entity.VolunteerProfile;
import com.CommunityVolunteerPlatform.project.Repositories.OrganizationProfileRepository;
import com.CommunityVolunteerPlatform.project.Repositories.UserRepository;
import com.CommunityVolunteerPlatform.project.Repositories.VolunteerProfileRepository;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ProfileController {

    @Autowired
    private UserRepository userRepo;
    @Autowired private VolunteerProfileRepository volunteerRepo;
    @Autowired private OrganizationProfileRepository orgRepo;

    @GetMapping("/profile")
    public String showProfileForm(Model model, Principal principal) {
        User user = userRepo.findByEmail(principal.getName());
        model.addAttribute("user", user);

        if ("volunteer".equalsIgnoreCase(user.getRole())) {
            VolunteerProfile profile = volunteerRepo.findByUser(user);
            if (profile == null) profile = new VolunteerProfile();
            model.addAttribute("profile", profile);
            return "volunteer_profile";
        } else {
            OrganizationProfile profile = orgRepo.findByUser(user);
            if (profile == null) profile = new OrganizationProfile();
            model.addAttribute("profile", profile);
            return "organization_profile";
        }
    }

    @PostMapping("/save-volunteer-profile")
    public String saveVolunteer(@ModelAttribute VolunteerProfile profile, Principal principal) {
        User user = userRepo.findByEmail(principal.getName());
        profile.setUser(user);
        volunteerRepo.save(profile);
        return "redirect:/view-volunteer-profile?success=true";
    }

    @PostMapping("/save-organization-profile")
    public String saveOrganization(@ModelAttribute OrganizationProfile profile, Principal principal) {
        User user = userRepo.findByEmail(principal.getName());
        profile.setUser(user);
        orgRepo.save(profile);
        return "redirect:/view-organization-profile?success=true";
    }

    @GetMapping("/view-volunteer-profile")
    public String viewVolunteerProfile(Model model, Principal principal,
                                       @RequestParam(value = "success", required = false) String success) {
        User user = userRepo.findByEmail(principal.getName());
        VolunteerProfile profile = volunteerRepo.findByUser(user);
        model.addAttribute("profile", profile);
        model.addAttribute("success", success != null);
        return "view_volunteer_profile";
    }

    @GetMapping("/view-organization-profile")
    public String viewOrganizationProfile(Model model, Principal principal,
                                          @RequestParam(value = "success", required = false) String success) {
        User user = userRepo.findByEmail(principal.getName());
        OrganizationProfile profile = orgRepo.findByUser(user);
        model.addAttribute("profile", profile);
        model.addAttribute("success", success != null);
        return "view_organization_profile";
    }
}
