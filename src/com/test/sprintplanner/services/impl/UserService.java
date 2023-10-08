package com.test.sprintplanner.services.impl;

import com.test.sprintplanner.factories.UserFactory;
import com.test.sprintplanner.beans.User;
import com.test.sprintplanner.repositories.UserRepository;
import com.test.sprintplanner.services.IUserService;

import java.util.Optional;

public class UserService implements IUserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(String name) {
        User user = UserFactory.createUser(name);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findById(String userId) {
        return userRepository.findByUserId(userId);
    }
}
