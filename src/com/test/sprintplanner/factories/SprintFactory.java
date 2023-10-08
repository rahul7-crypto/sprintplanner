package com.test.sprintplanner.factories;

import com.test.sprintplanner.beans.Sprint;

public class SprintFactory {

    public static Sprint createSprint(String name, long startTime, long endTime) {
        return new Sprint(name, startTime, endTime);
    }
}
