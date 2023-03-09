package com.codegym.case_study_modul_4.service;

import com.codegym.case_study_modul_4.model.entity.OrderDetail;
import com.codegym.case_study_modul_4.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OrderDetailService implements IOrderDetailService{

    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public Iterable<OrderDetail> findAll() {
        return null;
    }

//    @Override
//    public Iterable<OrderDetail> findAllById(Long id) {
//        return orderDetailRepository.findOrderDetailByOrderId(id);
//    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(OrderDetail orderDetail) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void saveAll(Iterable<OrderDetail> entities) {
    orderDetailRepository.saveAll(entities);
    }


}
