package com.codegym.case_study_modul_4.model.entity;


import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Long price;

    private Long quantity;

    private Long weigth;

    public Product() {
    }

    public Product(Long id, String name, Long price, Long quantity, Long weigth) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weigth = weigth;
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getWeigth() {
        return weigth;
    }

    public void setWeigth(Long weigth) {
        this.weigth = weigth;
    }
}
