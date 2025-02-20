package com.example.demo.createuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.createuser.model.User;
import com.example.demo.createuser.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User createUser(User user) {
       return userRepo.save(user);
    }
  
    public List<User> filterUsers(String name, String nrc, String phone) {
        if (name != null) return userRepo.findByname(name);
        if (nrc != null) return userRepo.findBynrc(nrc);
        if (phone != null) return userRepo.findByphone(phone);
        return userRepo.findAll();
    }


}
