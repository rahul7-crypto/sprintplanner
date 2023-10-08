package com.test.sprintplanner.beans;

import com.test.sprintplanner.enums.TaskStatus;
import com.test.sprintplanner.enums.TaskType;

import java.util.UUID;

public abstract class Task {
    private String id;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskType type;
    private String assignedTo;
    private long createdAt;
    private long updatedAt;

    public Task(String title, String description, TaskType type) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.status = TaskStatus.TODO;
        this.type = type;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }
}
