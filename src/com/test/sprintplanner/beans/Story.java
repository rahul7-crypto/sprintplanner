package com.test.sprintplanner.beans;

import com.test.sprintplanner.enums.TaskType;

public class Story extends Task {
    public Story(String title, String description) {
        super(title, description, TaskType.STORY);
    }
}
