package com.test.sprintplanner.repositories;

import com.test.sprintplanner.beans.Task;

import java.util.*;

public class TaskRepository {
    // TaskId to task map; It should be task id but for testing purpose we are keeping as task
    private Map<String, Task> taskMap;

    public TaskRepository() {
        this.taskMap = new HashMap<>();
    }

    public Task save(Task task) {
        task.setUpdatedAt(System.currentTimeMillis());
        taskMap.put(task.getId(), task);
        return task;
    }
    public Optional<Task> findTaskById(String taskId) {
        return Optional.ofNullable(taskMap.get(taskId));
    }

    public List<Task> findByIds(Set<String> taskIds) {
        List<Task> tasks = new ArrayList<>();
        for (String taskId : taskIds) {
            Task task = taskMap.get(taskId);
            if (task != null) {
                tasks.add(task);
            }
        }
        return tasks;
    }

}
