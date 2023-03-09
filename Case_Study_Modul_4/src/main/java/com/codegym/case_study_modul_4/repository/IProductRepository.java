package com.codegym.case_study_modul_4.repository;

import com.codegym.case_study_modul_4.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


@EnableJpaRepositories
public interface IProductRepository extends JpaRepository<Product,Long> {

    public List<Product> findProductById(Long id);

}
