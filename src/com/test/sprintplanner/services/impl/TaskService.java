package com.test.sprintplanner.services.impl;

import com.test.sprintplanner.beans.Task;
import com.test.sprintplanner.beans.User;
import com.test.sprintplanner.enums.TaskStatus;
import com.test.sprintplanner.enums.TaskType;
import com.test.sprintplanner.factories.TaskFactory;
import com.test.sprintplanner.repositories.TaskRepository;
import com.test.sprintplanner.services.ITaskService;

import java.util.List;
import java.util.Set;

public class TaskService implements ITaskService {

    private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(String title, String description, TaskType type) {
        Task task = TaskFactory.createTask(title, description, type);
        return taskRepository.save(task);
    }

    @Override
    public void changeStatus(Task task, TaskStatus status) {
        task.setStatus(status);
        taskRepository.save(task);
    }

    @Override
    public void assignUser(Task task, User user) {
        task.setAssignedTo(user.getId());
        taskRepository.save(task);
    }

    @Override
    public List<Task> findByIds(Set<String> taskIds) {
        return taskRepository.findByIds(taskIds);
    }
}
