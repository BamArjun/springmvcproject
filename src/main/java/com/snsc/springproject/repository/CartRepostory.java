package com.snsc.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.snsc.springproject.model.Cart;

public interface CartRepostory extends JpaRepository<Cart, Integer>{

}
