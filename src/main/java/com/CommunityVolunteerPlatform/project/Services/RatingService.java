package com.CommunityVolunteerPlatform.project.Services;





import com.CommunityVolunteerPlatform.project.Entity.Rating;
import com.CommunityVolunteerPlatform.project.Repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public void save(Rating rating) {
        ratingRepository.save(rating);
    }

    public List<Rating> getAllRatings() {
        return ratingRepository.findAll();
    }

    public Rating getById(Long id) {
        return ratingRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        ratingRepository.deleteById(id);
    }

    public List<Object[]> getTop10Volunteers() {
        return ratingRepository.findTop10Volunteers();
    }
}