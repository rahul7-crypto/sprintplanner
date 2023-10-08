package com.test.sprintplanner.repositories;

import com.test.sprintplanner.beans.User;

import java.util.*;

public class UserRepository {
    // UserId To User Map
    private Map<String, User> userMap;

    public UserRepository() {
        this.userMap = new HashMap<>();
    }

    public User save(User user) {
        user.setUpdatedAt(System.currentTimeMillis());
        userMap.put(user.getId(), user);
        return user;
    }
    public Optional<User> findByUserId(String userId) {
        return Optional.ofNullable(userMap.get(userId));
    }

}
