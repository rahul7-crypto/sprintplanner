package com.test.sprintplanner.services;

import java.util.Set;

public interface ISprintTaskService {
    Set<String> fetchSprintTaskIds(String sprintId);
    void addTask(String sprintId, String taskId);
    void removeTask(String sprintId, String taskId);
}
