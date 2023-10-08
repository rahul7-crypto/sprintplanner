package com.test.sprintplanner.services.impl;

import com.test.sprintplanner.repositories.SprintTaskRepository;
import com.test.sprintplanner.services.ISprintTaskService;

import java.util.Set;

public class SprintTaskService implements ISprintTaskService {

    private SprintTaskRepository sprintTaskRepository;

    public SprintTaskService(SprintTaskRepository sprintTaskRepository) {
        this.sprintTaskRepository = sprintTaskRepository;
    }

    @Override
    public Set<String> fetchSprintTaskIds(String sprintId) {
        return sprintTaskRepository.fetchSprintTasks(sprintId);
    }

    @Override
    public void addTask(String sprintId, String taskId) {
        sprintTaskRepository.addTask(sprintId, taskId);
    }

    @Override
    public void removeTask(String sprintId, String taskId) {
        sprintTaskRepository.removeTask(sprintId, taskId);
    }
}
