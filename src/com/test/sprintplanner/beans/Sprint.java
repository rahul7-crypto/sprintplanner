package com.test.sprintplanner.beans;

import java.util.UUID;

public class Sprint {
    private String id;
    private String name;
    private long startTime;
    private long endTime;
    private long createdAt;
    private long updatedAt;

    public Sprint(String name, long startTime, long endTime) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
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
}
