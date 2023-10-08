package com.test.sprintplanner.factories;

import com.test.sprintplanner.beans.Bug;
import com.test.sprintplanner.beans.Feature;
import com.test.sprintplanner.beans.Story;
import com.test.sprintplanner.beans.Task;
import com.test.sprintplanner.enums.TaskType;

public class TaskFactory {

    public static Task createTask(String title, String description, TaskType type) {
        switch (type) {
            case STORY:
                return new Story(title, description);
            case FEATURE:
                return new Feature(title, description);
            case BUG:
                return new Bug(title, description);
        }
        return null;
    }
}
