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

        Optional<User> user = userRepository.findByUsername(username);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return "redirect:/home";  // Redirect if login is successful
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";  // Show login page again with error message
        }
    }

    // Home page
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    // Show filter form
    @GetMapping("/filter")
    public String filterForm() {
        return "filter";
    }

    // Process user filtering
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
