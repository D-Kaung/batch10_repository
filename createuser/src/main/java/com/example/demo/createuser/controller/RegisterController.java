package com.example.demo.createuser.controller;

import com.example.demo.createuser.model.User;
import com.example.demo.createuser.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        return "/register";
    }

    @PostMapping("/register")
    public String processRegister(Model model, User user) {
        userServiceImpl.registerUser(user);
        return "redirect:/login";
    }
}
