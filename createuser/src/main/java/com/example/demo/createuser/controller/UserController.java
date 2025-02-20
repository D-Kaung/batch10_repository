package com.example.demo.createuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model; 

import com.example.demo.createuser.model.User;
import com.example.demo.createuser.service.UserService;


@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/users/list";
    }

    @GetMapping("/list")
    public String listUsers(@RequestParam(required = false) String name,
                            @RequestParam(required = false) String nrc,
                            @RequestParam(required = false) String phone,
                            Model model) {
        model.addAttribute("users", userService.filterUsers(name, nrc, phone));
        return "user-list";
    }

}
