package com.snsc.springproject.service;

import java.util.List;
import com.snsc.springproject.model.Product;

public interface CustomerProductService {
List<Product> getByCategory(String category);
List<Product> getAll();

}
