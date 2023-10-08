package com.test.sprintplanner.beans;

import com.test.sprintplanner.enums.TaskType;

public class Feature extends Task {

    public Feature(String title, String description) {
        super(title, description, TaskType.FEATURE);
    }
}
