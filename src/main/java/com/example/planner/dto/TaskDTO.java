package com.example.planner.dto;

import com.example.planner.model.Task;
import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private Boolean isCompleted;
    private Task.Priority priority;
    private Long userId;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
