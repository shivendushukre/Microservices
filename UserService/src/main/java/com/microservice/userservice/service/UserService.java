package com.microservice.userservice.service;

import com.microservice.userservice.entities.User;

import java.util.List;

public interface UserService {

    // user ops

    User saveUser(User user);

    // get all users
    List<User> getAllUser();

    // get single user

    User getUser(String userId);

    // TODO: Update and delete methods
}
