package com.CommunityVolunteerPlatform.project.Repositories;


import com.CommunityVolunteerPlatform.project.Entity.OrganizationProfile;
import com.CommunityVolunteerPlatform.project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationProfileRepository extends JpaRepository<OrganizationProfile, Long> {
    OrganizationProfile findByUser(User user);
}