package com.CommunityVolunteerPlatform.project.Repositories;




import com.CommunityVolunteerPlatform.project.Entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, Long> {

    @Query("SELECT r.volunteerName, AVG(r.stars) as avgStars FROM Rating r GROUP BY r.volunteerName ORDER BY avgStars DESC LIMIT 10")
    List<Object[]> findTop10Volunteers();
}