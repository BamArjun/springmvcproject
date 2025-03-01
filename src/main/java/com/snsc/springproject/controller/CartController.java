package com.snsc.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.snsc.springproject.model.Cart;
import com.snsc.springproject.model.Product;
import com.snsc.springproject.model.User;
import com.snsc.springproject.repository.ProductRepository;
import com.snsc.springproject.service.CartService;
import com.snsc.springproject.service.CustomerProductService;

import jakarta.servlet.http.HttpSession;


@Controller
public class CartController {
	@Autowired
	private CartService cs;
	@Autowired
	private ProductRepository pr;
	@Autowired
	private CustomerProductService cps;

	@GetMapping("/addcart")
	public String addCart(@RequestParam int id, HttpSession session) {
		System.out.println(session.getAttribute("valiUser"));
		User u= (User) session.getAttribute("validUser");
		System.out.println("---------------User name="+u.getName());
		
		Cart cart = new Cart();
		cart.setProduct(pr.getById(id));
		cart.setUser(u);
		
		cs.addTCart(cart);
		return "redirect:/";
	}
	
	@GetMapping("/cart/list")
	public  String  getCartItem() {
		return "CartItem";
		
	}
}
