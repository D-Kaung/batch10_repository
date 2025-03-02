package com.example.demo.createuser.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String name;
    private String phone;
    private String nrc;
    private String address;
    private String location;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    
    public User(String username,String name, String phone, String nrc, String address, String location, String password, UserRole role) {
        this.username = username;
        this.name = name;
        this.phone = phone;
        this.nrc = nrc;
        this.address = address;
        this.location = location;
        this.password = password;
        this.role = UserRole.USER;

    }

}
