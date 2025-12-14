package com.example.planner.repository;

import com.example.planner.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Найти все задачи пользователя
    List<Task> findByUserId(Long userId);

    // Найти завершённые задачи пользователя
    List<Task> findByUserIdAndIsCompletedTrue(Long userId);

    // Найти незавершённые задачи пользователя
    List<Task> findByUserIdAndIsCompletedFalse(Long userId);

    // Найти задачи по приоритету
    List<Task> findByUserIdAndPriority(Long userId, Task.Priority priority);
}
