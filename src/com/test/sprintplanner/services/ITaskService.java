package com.test.sprintplanner.services;

import com.test.sprintplanner.beans.User;
import com.test.sprintplanner.beans.Task;
import com.test.sprintplanner.enums.TaskStatus;
import com.test.sprintplanner.enums.TaskType;

import java.util.List;
import java.util.Set;

public interface ITaskService {
    Task createTask(String title, String description, TaskType type);
    void changeStatus(Task task, TaskStatus status);
    void assignUser(Task task, User user);
    List<Task> findByIds(Set<String> taskIds);
}
