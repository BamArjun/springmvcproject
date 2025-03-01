package com.snsc.springproject.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.snsc.springproject.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByCategory(String category);
	
	 List<Product> findByTitle(String title);
	 

}
