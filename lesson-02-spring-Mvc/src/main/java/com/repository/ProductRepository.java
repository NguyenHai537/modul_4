package com.repository;

import com.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface ProductRepository {
    List<Product> findAll();

    Product findByID(int id);

    void save(Product product);

    Product findById(int id);
}
