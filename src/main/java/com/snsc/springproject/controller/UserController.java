package com.snsc.springproject.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snsc.springproject.model.User;
import com.snsc.springproject.service.UserService;
import com.snsc.springproject.utils.VerifyRecaptcha;

import jakarta.servlet.http.HttpSession;
import lombok.extern.java.Log;

@Controller
@Log
public class UserController {
	@Autowired
	private UserService userservice;
	
//	@GetMapping("/")
//	public String getcustomerHome() {
//		return "CustomerHome";
//	}

	@GetMapping("/login")
	public String getLogin() {
		return "loginform";
	}

	@PostMapping("/login")
	public String postLogin(@ModelAttribute User user ,Model model , HttpSession session ,@RequestParam ("g-recaptcha-response") String gCode) throws IOException {
		if (VerifyRecaptcha.verify(gCode)) {
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User u = userservice.userLogin(user.getUsername(), user.getPassword());
		if (u != null) {
		
			log.info("----------------login success----------");
			session.setAttribute("validUser", u);
			session.setMaxInactiveInterval(200);
		//	model.addAttribute("uname",user.getUsername());
			if (u.getRole().equals("ADMIN")) {
				return "homepage";	
			}else {
				return "CustomerHome";
			}
			
			
		}else {
			log.info("-----------login failed-----------");
			model.addAttribute("message","user not found");
			return "loginform";
		}
		}
		log.info("-----------login failed-----------");
		model.addAttribute("message","You are robort.");
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
		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		userservice.userSignup(user);
		return "loginform";
	}
	@GetMapping("/logout")
 public String Logout( HttpSession session) {
		log.info("-------------logout success------");
		session.invalidate();
	return "loginform";
	 
 }
	@GetMapping("/profile")
	public String profile() {
		return "Profile";
		
	}
}
