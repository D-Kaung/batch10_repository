package com.example.demo.createuser.controller;

import com.example.demo.createuser.repository.UserRepository;
import com.example.demo.createuser.model.User;
import com.example.demo.createuser.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    //create a home form
    @GetMapping("/home")
    public String home() {
        return "home";
    }

    //create a filter form
    @GetMapping("/filter")
    public String filterForm() {
        return "filter";
    }

    //the function for filter form
    @PostMapping("/filter")
    public String filterUsers(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String phone,
                              @RequestParam(required = false) String nrc,
                              Model model) {
        List<User> users = userRepository.findByNameContainingOrPhoneContainingOrNrcContaining(name, phone, nrc);
        model.addAttribute("users", users);
        return "filter";
    }

    @PostMapping("/save")
     public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/home";
   }

   @GetMapping("/delete/{id}")
   public String deleteUser(@PathVariable(value = "id") User user) {
        userService.deleteUser(user);
        return "redirect:/home";
   }
}
