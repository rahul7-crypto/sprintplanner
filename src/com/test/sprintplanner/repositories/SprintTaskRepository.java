package com.test.sprintplanner.repositories;

import java.util.*;

public class SprintTaskRepository {

    private Map<String, Set<String>> sprintTasks;

    public SprintTaskRepository() {
        this.sprintTasks = new HashMap<>();
    }

    public void addTask(String sprintId, String taskId) {
        Set<String> existingSprintTasks = sprintTasks.getOrDefault(sprintId, new HashSet<>());
        if (existingSprintTasks.contains(taskId)) {
            return;
        }
        existingSprintTasks.add(taskId);
        sprintTasks.put(sprintId, existingSprintTasks);
    }

    public void removeTask(String sprintId, String taskId) {
        Set<String> existingSprintTasks = sprintTasks.getOrDefault(sprintId, new HashSet<>());
        if (!existingSprintTasks.contains(taskId)) {
            throw new RuntimeException("Task is not present in Sprint!");
        }
        existingSprintTasks.remove(taskId);
        sprintTasks.put(sprintId, existingSprintTasks);
    }

    public Set<String> fetchSprintTasks(String sprintId) {
        return sprintTasks.getOrDefault(sprintId, new HashSet<>());
    }
}
