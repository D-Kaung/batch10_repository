package com.example.demo.createuser.service;

import com.example.demo.createuser.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(User user);
}
