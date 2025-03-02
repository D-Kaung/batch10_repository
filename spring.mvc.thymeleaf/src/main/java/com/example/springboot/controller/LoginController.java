package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.repository.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class LoginController {

	private final UserDao userDao;

	// Show login form
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("user", new User());
		return "/login";
	}

	// Process login
	@PostMapping("/login")
	public String login(@RequestParam String username,
						@RequestParam String password,
						Model model) {

			return "redirect:/home";


		}
	}
