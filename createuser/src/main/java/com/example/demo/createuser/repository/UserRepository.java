package com.example.demo.createuser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.createuser.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    List<User> findByname(String name);

    List<User> findBynrc(String nrc);

    List<User> findByphone(String phone);


}
