package com.codegym.case_study_modul_4.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "transportation")
public class Transportation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String licensePlates;
    private Long weight;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Transportation(Long id, String name, String licensePlates, Long weight, Order order) {
        this.id = id;
        this.name = name;
        this.licensePlates = licensePlates;
        this.weight = weight;
        this.order = order;
    }

    public Transportation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public Long getWeight() {
        return weight;
    }

    public void setWeight(Long weight) {
        this.weight = weight;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
