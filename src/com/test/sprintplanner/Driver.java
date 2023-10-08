package com.test.sprintplanner;

import com.test.sprintplanner.services.IUserService;
import com.test.sprintplanner.services.impl.UserService;
import com.test.sprintplanner.beans.Sprint;
import com.test.sprintplanner.beans.Task;
import com.test.sprintplanner.beans.User;
import com.test.sprintplanner.enums.TaskStatus;
import com.test.sprintplanner.enums.TaskType;
import com.test.sprintplanner.repositories.SprintRepository;
import com.test.sprintplanner.repositories.SprintTaskRepository;
import com.test.sprintplanner.repositories.TaskRepository;
import com.test.sprintplanner.repositories.UserRepository;
import com.test.sprintplanner.services.ISprintService;
import com.test.sprintplanner.services.ISprintTaskService;
import com.test.sprintplanner.services.ITaskService;
import com.test.sprintplanner.services.impl.SprintService;
import com.test.sprintplanner.services.impl.SprintTaskService;
import com.test.sprintplanner.services.impl.TaskService;

public class Driver {

    public static void main(String[] args) {
        // Create Repositories
        UserRepository userRepository = new UserRepository();
        SprintRepository sprintRepository = new SprintRepository();
        TaskRepository taskRepository = new TaskRepository();
        SprintTaskRepository sprintTaskRepository = new SprintTaskRepository();

        // Create Services
        IUserService userService = new UserService(userRepository);
        ISprintTaskService sprintTaskService = new SprintTaskService(sprintTaskRepository);
        ITaskService taskService = new TaskService(taskRepository);
        ISprintService sprintService = new SprintService(sprintRepository, sprintTaskService, taskService);

        User user1 = userService.createUser("Rahul");
        Sprint janSprint = sprintService.createSprint("Jan", 1, 24);
        Task janTask1 = taskService.createTask("Jan Task 1", "Jan Task 1", TaskType.STORY);
        Task janTask2 = taskService.createTask("Jan Task 2", "Jan Task 2", TaskType.FEATURE);
        Task janTask3 = taskService.createTask("Jan Task 3", "Jan Task 3", TaskType.BUG);

        sprintService.addTask(janSprint, janTask1);
        sprintService.addTask(janSprint, janTask2);
        sprintService.addTask(janSprint, janTask3);

        taskService.assignUser(janTask1, user1);
        taskService.assignUser(janTask2, user1);
        taskService.assignUser(janTask3, user1);

        sprintService.changeStatus(janSprint, janTask1, TaskStatus.INPROGRESS);
        sprintService.changeStatus(janSprint, janTask2, TaskStatus.INPROGRESS);
//        sprintService.changeStatus(janSprint, janTask3, TaskStatus.INPROGRESS);

        System.out.println(sprintService.findDelayedTasks(janSprint));
        System.out.println(sprintService.findUserTasks(janSprint, user1));
    }
}
