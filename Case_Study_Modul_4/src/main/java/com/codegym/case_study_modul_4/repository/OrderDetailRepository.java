package com.codegym.case_study_modul_4.repository;

import com.codegym.case_study_modul_4.model.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

    public List<OrderDetail> findOrderDetailByOrderId(Long id);

}
