package com.CommunityVolunteerPlatform.project.Services;
import com.CommunityVolunteerPlatform.project.Entity.Task;
import com.CommunityVolunteerPlatform.project.Repositories.TaskRepository;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    public void save(Task task) {
        taskRepository.save(task);
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }

    public List<Task> searchByKeyword(String keyword) {
        return taskRepository.findByTitleContainingIgnoreCase(keyword);
    }

    public List<Task> filterBySkill(String skill) {
        return taskRepository.findBySkillsContainingIgnoreCase(skill);
    }

    public List<Task> filterByDate(LocalDate date) {
        return taskRepository.findByDate(date);
    }

    public List<Task> filterByLocation(String location) {
        return taskRepository.findByLocationContainingIgnoreCase(location);
    }
}