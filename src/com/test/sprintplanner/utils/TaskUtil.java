package com.test.sprintplanner.utils;

import com.test.sprintplanner.enums.TaskStatus;
import com.test.sprintplanner.beans.Task;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskUtil {

    public static int countTasksByStatus(List<Task> tasks, TaskStatus status, String userId) {
        return (int) Optional.ofNullable(tasks).orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .filter(task -> status.equals(task.getStatus()) && userId.equals(task.getAssignedTo()))
                .count();
    }

    public static List<Task> fetchUserTasks(List<Task> tasks, String userId) {
        return Optional.ofNullable(tasks).orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .filter(task -> userId.equals(task.getAssignedTo()))
                .collect(Collectors.toList());
    }
}
