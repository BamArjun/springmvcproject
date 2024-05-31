package com.snsc.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.snsc.springproject.model.User;
import com.snsc.springproject.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userservice;

	@GetMapping({"/","/login"})
	public String getLogin() {
		return "loginform";
	}

	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user ,Model model ) {
		User u = userservice.userLogin(user.getUsername(), user.getPassword());
		if (u != null) {
			model.addAttribute("uname",user.getUsername());
			return "homepage";
		}
		model.addAttribute("message","user not found");
		return "loginform";
	}

	@GetMapping("/signup")
	public String getSignup() {
		return "SignupForm";
	}

	@PostMapping("/signup")
	public String postsignup(@ModelAttribute User user, Model model) {
		User usr = userservice.isUserExist(user.getUsername());
		if (usr != null) {
			model.addAttribute("message", "username already exist");
			return "signupform";
		}
		userservice.userSignup(user);
		return "loginform";
	}
	@GetMapping("/logout")
 public String Logout() {
	return "loginform";
	 
 }
}
