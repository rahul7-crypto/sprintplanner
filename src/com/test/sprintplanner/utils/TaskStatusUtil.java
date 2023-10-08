package com.test.sprintplanner.utils;

import com.test.sprintplanner.enums.TaskStatus;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TaskStatusUtil {

    public static final Map<TaskStatus, Set<TaskStatus>> nextAllowedStatus = new HashMap<>();

    static {
        nextAllowedStatus.put(TaskStatus.TODO, Set.of(TaskStatus.INPROGRESS));
        nextAllowedStatus.put(TaskStatus.INPROGRESS, Set.of(TaskStatus.TODO, TaskStatus.DONE));
    }

}
