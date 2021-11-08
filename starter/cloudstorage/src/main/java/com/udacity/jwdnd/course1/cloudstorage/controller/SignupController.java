package com.udacity.jwdnd.course1.cloudstorage.controller;

import javax.validation.Valid;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.udacity.jwdnd.course1.cloudstorage.entity.User;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;

@Controller
public class SignupController {
	
	private UserService userService;
	
	public SignupController(UserService userService) {
		// TODO Auto-generated constructor stub
		this.userService = userService;
	}
	
	@GetMapping("/signup")
	public String getSignupPage(User user, Model model) {
		return "signup";
	}
	
	@PostMapping("/signup")
	public String saveUser(@Valid User user, BindingResult  result,  Model model) {
		if(result.hasErrors()) {
			return "signup";
		}
		userService.creatUser(user);
		model.addAttribute("success", true);
		return "signup";
	}
	
}