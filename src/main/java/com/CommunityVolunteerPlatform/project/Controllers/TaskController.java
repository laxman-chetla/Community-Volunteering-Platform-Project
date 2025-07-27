package com.CommunityVolunteerPlatform.project.Controllers;
import com.CommunityVolunteerPlatform.project.Entity.Task;
import com.CommunityVolunteerPlatform.project.Services.TaskService;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller

public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/HomeAfterLogin")
    public String homeAfterLogin() {
        return "HomeAfterLogin";
    }

    @GetMapping("/tasks")
    public String viewTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
       return "task_list";

    }

    @GetMapping("/tasks/new")
    public String showCreateForm(Model model) {
        model.addAttribute("task", new Task());
        return "task_form";
    }

    @PostMapping("/tasks/save")
    public String saveTask(@ModelAttribute Task task) {
        taskService.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "task_form";
    }

    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.delete(id);
        return "redirect:/tasks";
    }

    @GetMapping("/tasks/search-filter")
    public String searchFilterPage() {
        return "search_filter";
    }

    @PostMapping("/tasks/search-filter")
    public String searchFilterResults(
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false) String skill,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String date,
            Model model
    ) {
        List<Task> tasks = taskService.getAllTasks();

        if (keyword != null && !keyword.isEmpty())
            tasks = taskService.searchByKeyword(keyword);
        else if (skill != null && !skill.isEmpty())
            tasks = taskService.filterBySkill(skill);
        else if (location != null && !location.isEmpty())
            tasks = taskService.filterByLocation(location);
        else if (date != null && !date.isEmpty())
            tasks = taskService.filterByDate(LocalDate.parse(date));

        model.addAttribute("tasks", tasks);
        return "search_filter";
    }
}