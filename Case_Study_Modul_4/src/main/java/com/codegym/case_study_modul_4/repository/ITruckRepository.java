package com.codegym.case_study_modul_4.repository;

import com.codegym.case_study_modul_4.model.entity.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface ITruckRepository extends JpaRepository<Truck,Long> {

    public Truck findByLicensePlates(String licensePlates);
}
