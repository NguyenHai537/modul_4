package com.codegym.case_study_modul_4.service;

import com.codegym.case_study_modul_4.model.entity.Order;
import com.codegym.case_study_modul_4.repository.IInventoryOrderRepository;
import com.codegym.case_study_modul_4.repository.IProductRepository;
import com.codegym.case_study_modul_4.util.Mapper.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryOrderService implements IInventoryOrderService{


    @Autowired
    private IInventoryOrderRepository inventoryOrderRepository;

    @Override
    public Iterable<Order> findAll() {

        return inventoryOrderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(Long id) {

        return inventoryOrderRepository.findById(id);
    }

    @Override
    public void save(Order order) {

        inventoryOrderRepository.save(order);
    }


    @Override
    public void remove(Long id) {

    }

    @Override
    public void saveAll(Iterable<Order> entities) {

    }
//
//    @Override
//    public List<Order> saveAllAndFlush(Iterable<Order> entities) {
//        RequestMapper requestMapper = new RequestMapper();
//
//    }
}
