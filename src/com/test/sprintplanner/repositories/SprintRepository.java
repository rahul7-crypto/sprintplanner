package com.test.sprintplanner.repositories;

import com.test.sprintplanner.beans.Sprint;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class SprintRepository {
    // Map of sprintId to Sprint
    private Map<String, Sprint> sprintMap;

    public SprintRepository() {
        this.sprintMap = new HashMap<>();
    }

    public Sprint save(Sprint sprint) {
        sprint.setUpdatedAt(System.currentTimeMillis());
        sprintMap.put(sprint.getId(), sprint);
        return sprint;
    }

    public Optional<Sprint> findById(String sprintId) {
        return Optional.ofNullable(sprintMap.get(sprintId));
    }

}
