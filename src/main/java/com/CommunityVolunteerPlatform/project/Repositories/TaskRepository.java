package com.CommunityVolunteerPlatform.project.Repositories;
import com.CommunityVolunteerPlatform.project.Entity.Task;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByTitleContainingIgnoreCase(String keyword);
    List<Task> findBySkillsContainingIgnoreCase(String skill);
    List<Task> findByDate(LocalDate date);
    List<Task> findByLocationContainingIgnoreCase(String location);
}