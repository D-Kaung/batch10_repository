package com.example.demo.createuser.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String phone;
    private String nrc;
    private String address;
    
    public User(String name, String phone, String nrc, String address) {
        this.name = name;
        this.phone = phone;
        this.nrc = nrc;
        this.address = address;
    }

    

}
