package com.test.sprintplanner.services.impl;

import com.test.sprintplanner.services.ISprintTaskService;
import com.test.sprintplanner.utils.TaskStatusUtil;
import com.test.sprintplanner.utils.TaskUtil;
import com.test.sprintplanner.beans.User;
import com.test.sprintplanner.services.ISprintService;
import com.test.sprintplanner.services.ITaskService;
import com.test.sprintplanner.enums.TaskStatus;
import com.test.sprintplanner.beans.Sprint;
import com.test.sprintplanner.beans.Task;
import com.test.sprintplanner.factories.SprintFactory;
import com.test.sprintplanner.repositories.SprintRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SprintService implements ISprintService {

    private SprintRepository sprintRepository;
    private ISprintTaskService sprintTaskService;
    private ITaskService taskService;

    public SprintService(SprintRepository sprintRepository, ISprintTaskService sprintTaskService,
                         ITaskService taskService) {
        this.sprintRepository = sprintRepository;
        this.sprintTaskService = sprintTaskService;
        this.taskService = taskService;
    }

    @Override
    public Sprint createSprint(String name, long startTime, long endTime) {
        Sprint sprint = SprintFactory.createSprint(name, startTime, endTime);
        return sprintRepository.save(sprint);
    }

    @Override
    public void addTask(Sprint sprint, Task task) {
        Set<String> taskIds = sprintTaskService.fetchSprintTaskIds(sprint.getId());
        if (taskIds.size() >= 20) {
            throw new RuntimeException("Maximum 20 tasks can be added to the sprint");
        }
        sprintTaskService.addTask(sprint.getId(), task.getId());
    }

    @Override
    public void removeTask(Sprint sprint, Task task) {
        sprintTaskService.removeTask(sprint.getId(), task.getId());
    }

    @Override
    public void changeStatus(Sprint sprint, Task task, TaskStatus status) {
        Set<String> taskIds = sprintTaskService.fetchSprintTaskIds(sprint.getId());
        if (!taskIds.contains(task.getId())) {
            throw new RuntimeException("Task is not part of this Sprint!");
        }

        Set<TaskStatus> allowedStatuses = TaskStatusUtil.nextAllowedStatus.get(task.getStatus());
        if (!allowedStatuses.contains(status)) {
            throw new RuntimeException("Invalid new Status!");
        }
        List<Task> sprintTasks = taskService.findByIds(taskIds);
        int numberOfInProgressTasks = TaskUtil.countTasksByStatus(sprintTasks, TaskStatus.INPROGRESS, task.getAssignedTo());
        if (numberOfInProgressTasks >= 2 && TaskStatus.INPROGRESS.equals(status)) {
            throw new RuntimeException("Maximum 2 tasks can be in progress in a sprint for a User!");
        }
        taskService.changeStatus(task, status);
    }


    @Override
    public List<Task> findDelayedTasks(Sprint sprint) {
        Set<String> taskIds = sprintTaskService.fetchSprintTaskIds(sprint.getId());
        List<Task> sprintTasks = taskService.findByIds(taskIds);
        List<Task> delayedTasks = new ArrayList<>();

        long currentTime = System.currentTimeMillis();
        for (Task task : sprintTasks) {
            if (sprint.getEndTime() < currentTime && (!TaskStatus.DONE.equals(task.getStatus())
                    || (TaskStatus.DONE.equals(task.getStatus()) && task.getUpdatedAt() > currentTime))) {
                delayedTasks.add(task);
            }
        }
        return delayedTasks;
    }

    @Override
    public List<Task> findUserTasks(Sprint sprint, User user) {
        Set<String> taskIds = sprintTaskService.fetchSprintTaskIds(sprint.getId());
        List<Task> sprintTasks = taskService.findByIds(taskIds);
        return TaskUtil.fetchUserTasks(sprintTasks, user.getId());
    }
}
