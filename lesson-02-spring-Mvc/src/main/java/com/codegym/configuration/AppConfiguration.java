package com.codegym.configuration;

import com.repository.ProductRepository;
import com.repository.ProductRepositoryImpl;
import com.service.ProductService;
import com.service.ProductServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfiguration {
    @Bean
    public ProductService productService(){
        return new ProductServiceImpl();
    }

    @Bean
    public ProductRepository productRepository(){
        return  new ProductRepositoryImpl();
    }

}
