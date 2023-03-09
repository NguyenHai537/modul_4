package com.codegym.case_study_modul_4.service;

import com.codegym.case_study_modul_4.model.entity.Product;
import com.codegym.case_study_modul_4.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{

    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

//    @Override
//    public Iterable<Product> findAllById(Long id) {
//        return iProductRepository.findProductById(id);
//    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void saveAll(Iterable<Product> products) {
         iProductRepository.saveAll(products);
    }
}
