package com.test.sprintplanner.beans;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private long createdAt;
    private long updatedAt;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }
}
