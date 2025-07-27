package com.CommunityVolunteerPlatform.project.Repositories;


// === UserRepository.java ===


import com.CommunityVolunteerPlatform.project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    void deleteByEmail(String email);

    void deleteByEmail(User user);
}




















