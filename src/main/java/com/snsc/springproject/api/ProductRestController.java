package com.snsc.springproject.api;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.snsc.springproject.model.Product;
import com.snsc.springproject.repository.ProductRepository;

@RestController
public class ProductRestController {
	@Autowired
	private ProductRepository productrepo;
	
	@GetMapping("/api/pro/pload")
public String loadProduct() {
		RestTemplate rest = new RestTemplate();
	Product[] pro=rest.getForObject("https://fakestoreapi.com/products", Product[].class);
	productrepo.saveAll(List.of(pro));
	return "success";
	
}
}
