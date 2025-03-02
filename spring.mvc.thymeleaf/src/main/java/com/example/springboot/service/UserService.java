package com.example.springboot.service;

import com.example.springboot.model.User;

import java.util.List;

public interface UserService {

    void registerUser(User user);

    List<User> findAllUsers();

}
