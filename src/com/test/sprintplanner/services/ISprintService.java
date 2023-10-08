package com.test.sprintplanner.services;

import com.test.sprintplanner.beans.User;
import com.test.sprintplanner.enums.TaskStatus;
import com.test.sprintplanner.beans.Sprint;
import com.test.sprintplanner.beans.Task;

import java.util.List;

public interface ISprintService {
    Sprint createSprint(String name, long startTime, long endTime);
    void addTask(Sprint sprint, Task task);
    void removeTask(Sprint sprint, Task task);
    void changeStatus(Sprint sprint, Task task, TaskStatus status);
    List<Task> findDelayedTasks(Sprint sprint);

    List<Task> findUserTasks(Sprint sprint, User user);
}
