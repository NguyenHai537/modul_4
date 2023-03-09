package com.codegym.case_study_modul_4.repository;

import com.codegym.case_study_modul_4.model.entity.Transportation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface ITransportationRepository extends JpaRepository<Transportation,Long> {

    public List<Transportation> findByOrderId(Long id);
}
