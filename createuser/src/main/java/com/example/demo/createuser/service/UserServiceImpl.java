package com.example.demo.createuser.service;

import com.example.demo.createuser.model.User;
import com.example.demo.createuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

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
       userRepository.save(user);


    }
}
