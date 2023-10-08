package com.test.sprintplanner.beans;

import com.test.sprintplanner.enums.TaskType;

public class Bug extends Task {
    public Bug(String title, String description) {
        super(title, description, TaskType.BUG);
    }
}
