package com.snsc.springproject.seviceimpl;

import com.snsc.springproject.model.Product;

import com.snsc.springproject.repository.ProductRepository;
import com.snsc.springproject.service.CustomerProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerProductServiceImpl implements CustomerProductService {

    private final ProductRepository productRepository;

    @Autowired
    public CustomerProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
