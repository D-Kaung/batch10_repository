package com.example.springboot.service;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(User user) {
        user.setUsername(user.getUsername());
        user.setPhone(user.getPhone());
        user.setName(user.getName());
        user.setAddress(user.getAddress());
        user.setNrc(user.getNrc());
        user.setLocation(user.getLocation());
        user.setId(user.getId());
        user.setRole(user.getRole());
        String encodedPassword = passwordEncoder.encode(user.getPassword()); // Encrypt password
        user.setPassword(encodedPassword);
        userDao.save(user);

    }

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }
}