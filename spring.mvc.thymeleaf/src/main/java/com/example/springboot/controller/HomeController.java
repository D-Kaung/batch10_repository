package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserDao;
import com.example.springboot.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final UserServiceImpl userService;
    private final UserDao userDao;

    @GetMapping
    public String home(@RequestParam(value = "search", required = false) String search,
                       @AuthenticationPrincipal UserDetails userDetails,
                       Model model) {


        if (userDetails == null) {
            return "redirect:/login";
        }

        // Determine if user is an admin
        boolean isAdmin = userDetails.getAuthorities()
                .stream()
                .anyMatch(authority ->
                        authority.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            List<User> users = userDao.findAll();
            model.addAttribute("usersList", users);
        }
        // Fetch users based on role
        List<User> users = userService.findAllUsers();
        if (search != null && !search.isEmpty()) {
            users = users
                    .stream()
                    .filter(user -> user.getUsername().contains(search))
                    .collect(Collectors.toList());
        }

        // Add attributes to the model
        model.addAttribute("usersList", users);
        model.addAttribute("userCount", users.size());
        model.addAttribute("ADMIN", isAdmin);
        model.addAttribute("username", userDetails.getUsername());
        model.addAttribute("search", search);

        return "home";
    }
}
