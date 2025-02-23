package com.example.demo.createuser.controller;

import com.example.demo.createuser.model.User;
import com.example.demo.createuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final UserRepository userRepository;
    //using BCryptPasswordEncoder from PasswordEncoder interface for password hasCode
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Show login form
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    // Process login
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {

        //Using optional for escape from nullPointerException when we login
        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent() && passwordEncoder.matches(password, user.get().getPassword())) {
            return "redirect:/home";  // Correct redirection
        } else {
            model.addAttribute("error", "Invalid credentials");
            return "login";
        }
    }
}
