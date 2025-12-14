package com.example.planner.controller;

import com.example.planner.model.Task;
import com.example.planner.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    // GET все задачи
    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    // GET задачу по ID
    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    // ✅ POST - Создать задачу
    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    // PUT - Обновить задачу
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task taskDetails) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            task.setTitle(taskDetails.getTitle());
            task.setDescription(taskDetails.getDescription());
            task.setIsCompleted(taskDetails.getIsCompleted());  // ← Используйте setIsCompleted()
            task.setPriority(taskDetails.getPriority());
            task.setUserId(taskDetails.getUserId());
            task.setDueDate(taskDetails.getDueDate());
            return taskRepository.save(task);
        }
        return null;
    }

    // DELETE - Удалить задачу
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }
}
