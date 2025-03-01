package com.snsc.springproject.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.snsc.springproject.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class GalleryController {
	@Autowired
	private ProductRepository prodrepo;

	@GetMapping("/gallary")
	public String getGallery(Model model , HttpSession session) {
		if (session.getAttribute("validUser")==null) {
			return"loginform";
			
		}
		String[] imgNames = new File("src/main/resources/static/images").list();
		model.addAttribute("imgnamelist", imgNames);
		return "Gallery";

	}
	@GetMapping("/productgallery")
	public String productgallery( Model model) {
		model.addAttribute("productlist", prodrepo.findAll());
		
		return "ProductGallery";
		}
}
