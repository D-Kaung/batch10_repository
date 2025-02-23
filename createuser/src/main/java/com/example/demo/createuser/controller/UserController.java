package com.example.demo.createuser.controller;

import com.example.demo.createuser.repository.UserRepository;
import com.example.demo.createuser.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/filter")
    public String filterForm() {
        return "filter";
    }

    @PostMapping("/filter")
    public String filterUsers(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String phone,
                              @RequestParam(required = false) String nrc,
                              Model model) {
        List<User> users = userRepository.findByNameContainingOrPhoneContainingOrNrcContaining(name, phone, nrc);
        model.addAttribute("users", users);
        return "filter";
    }
}
