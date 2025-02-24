package com.example.demo.createuser.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.createuser.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

    List<User> findByNameContainingOrPhoneContainingOrNrcContaining(String name, String phone, String nrc);

    User findByName(String name);

    Optional<User> findByUsername(String username);


    User findUserByUsername(String username);
}
