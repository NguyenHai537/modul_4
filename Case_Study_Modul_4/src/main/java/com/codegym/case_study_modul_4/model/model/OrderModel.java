package com.codegym.case_study_modul_4.model.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class OrderModel implements Serializable {

    private Long id;

    private Long totalPrice;

    private Date delivery;

    private List<TransportationModel> transportationModels;

    public OrderModel() {
    }

    public OrderModel(Long id, Long totalPrice, Date delivery, List<TransportationModel> transportationModels) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.delivery = delivery;
        this.transportationModels = transportationModels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<TransportationModel> getTransportationModels() {
        return transportationModels;
    }

    public void setTransportationModels(List<TransportationModel> transportationModels) {
        this.transportationModels = transportationModels;
    }
}
