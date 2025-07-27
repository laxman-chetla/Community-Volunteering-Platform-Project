package com.CommunityVolunteerPlatform.project.Controllers;





import com.CommunityVolunteerPlatform.project.Entity.Rating;
import com.CommunityVolunteerPlatform.project.Services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/ratings")
public class RatingController {

    @Autowired
    private RatingService ratingService;

    @GetMapping("/new")
    public String showRatingForm(Model model) {
        model.addAttribute("rating", new Rating());
        return "rating_form";
    }

    @PostMapping("/save")
    public String saveRating(@ModelAttribute Rating rating) {
        rating.setDate(LocalDate.now());
        ratingService.save(rating);
        return "redirect:/ratings/view";
    }

    @GetMapping("/view")
    public String viewRatings(Model model) {
        model.addAttribute("ratings", ratingService.getAllRatings());
        model.addAttribute("top10", ratingService.getTop10Volunteers());
        return "view_ratings";
    }

    @GetMapping("/edit/{id}")
    public String editRating(@PathVariable Long id, Model model) {
        model.addAttribute("rating", ratingService.getById(id));
        return "rating_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteRating(@PathVariable Long id) {
        ratingService.deleteById(id);
        return "redirect:/ratings/view";
    }
}