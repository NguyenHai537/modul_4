package com.codegym.case_study_modul_4.service;

import com.codegym.case_study_modul_4.model.entity.Truck;
import com.codegym.case_study_modul_4.repository.ITruckRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class TruckService implements ITruckService{

    @Autowired
    private ITruckRepository iTruckRepository;
    @Override
    public Iterable<Truck> findAll() {
        return iTruckRepository.findAll();
    }


    @Override
    public Optional<Truck> findById(Long id) {
        return iTruckRepository.findById(id);
    }

    @Override
    public void save(Truck truck) {
        iTruckRepository.save(truck);
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void saveAll(Iterable<Truck> entities) {
        iTruckRepository.saveAll(entities);
    }

    @Override
    public Truck findTruckByLicensePlates(String licensePlates){
        return iTruckRepository.findByLicensePlates(licensePlates);
    }
}
