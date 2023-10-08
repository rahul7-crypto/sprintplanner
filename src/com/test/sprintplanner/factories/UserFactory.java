package com.test.sprintplanner.factories;

import com.test.sprintplanner.beans.User;

public class UserFactory {

    public static User createUser(String name) {
        return new User(name);
    }
}
