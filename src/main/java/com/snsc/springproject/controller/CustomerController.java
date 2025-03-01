package com.snsc.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.snsc.springproject.repository.ProductRepository;
import com.snsc.springproject.service.CustomerProductService;

@Controller
public class CustomerController {
	@Autowired
	private ProductRepository pr;
	@Autowired
	private CustomerProductService cps;
	
	@GetMapping("/")
	public String productimg( Model model) {
		model.addAttribute("plist",cps.getAll());
		return "CustomerHome";
		}
	@GetMapping("/mensproduct")
	public String getMensProduct(Model model) {
		model.addAttribute("mlist", cps.getByCategory("men's clothing"));
		
		return "MensProduct";
	}
}

