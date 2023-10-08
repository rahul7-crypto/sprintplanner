package com.test.sprintplanner.services;

import com.test.sprintplanner.beans.User;

import java.util.Optional;

public interface IUserService {
    User createUser(String name);

    Optional<User> findById(String userId);
}
