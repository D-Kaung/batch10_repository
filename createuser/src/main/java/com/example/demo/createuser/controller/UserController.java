package com.example.demo.createuser.controller;

import com.example.demo.createuser.model.User;
import com.example.demo.createuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    @GetMapping("/home")
    public String home(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        // Check if userDetails is not null
        if (userDetails != null) {
            // Check if the user is an admin
            boolean isAdmin = userDetails.getAuthorities().stream()
                    .anyMatch(authority -> authority.getAuthority().equals("ROLE_ADMIN"));

            // If the user is an admin, retrieve all users from the repository
            if (isAdmin) {
                List<User> userList = userRepository.findAll();
                model.addAttribute("userList", userList);
            }

            // Add the admin status and username to the model
            model.addAttribute("ADMIN", isAdmin);
            model.addAttribute("username", userDetails.getUsername());
        } else {
            // Optionally handle the case when userDetails is null
            // For example, you could redirect to a login page or display a message
            return "redirect:/login"; // Redirect to login page if not authenticated
        }

        return "home"; // Return the home view
    }

}
