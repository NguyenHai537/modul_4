package com.codegym.case_study_modul_4.model.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "order_request")
public class Order {

    @Id
    private Long id;

    private String status;

    private Long totalPrice;

    private Date delivery;

    private Long debt;


    @OneToMany(mappedBy = "order",cascade=CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "order")
    private List<Transportation> transportationList;

    public Order(Long id, String status, Long totalPrice, Date delivery, Long debt,
                 List<OrderDetail> orderDetails, List<Transportation> transportationList) {
        this.id = id;
        this.status = status;
        this.totalPrice = totalPrice;
        this.delivery = delivery;
        this.debt = debt;
        this.orderDetails = orderDetails;
        this.transportationList = transportationList;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDelivery() {
        return delivery;
    }

    public void setDelivery(Date delivery) {
        this.delivery = delivery;
    }

    public Long getDebt() {
        return debt;
    }

    public void setDebt(Long debt) {
        this.debt = debt;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<Transportation> getTransportationList() {
        return transportationList;
    }

    public void setTransportationList(List<Transportation> transportationList) {
        this.transportationList = transportationList;
    }
}
