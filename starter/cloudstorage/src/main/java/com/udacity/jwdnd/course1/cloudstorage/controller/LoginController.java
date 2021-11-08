package com.udacity.jwdnd.course1.cloudstorage.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.udacity.jwdnd.course1.cloudstorage.entity.User;

@Controller
public class LoginController {
	
	
	@GetMapping("/login")
	String getLoginPage(@RequestParam("logout") Optional<String> logout, @RequestParam("error") Optional<String> error, User user, Model model) {
		if(logout.isPresent())
			model.addAttribute("logout", true);
		if(error.isPresent())
			model.addAttribute("error", true);
		return "login";
	}
	
	@PostMapping("/login")
	String login(User user) {
		return "home";
	}
	
	
}
