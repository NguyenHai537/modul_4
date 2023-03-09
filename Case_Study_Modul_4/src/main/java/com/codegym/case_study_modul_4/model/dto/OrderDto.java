package com.codegym.case_study_modul_4.model.dto;

import com.codegym.case_study_modul_4.model.entity.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto implements Serializable {

    private Long id;

    private String status;

    private List<OrderDetailRequestDto> orderDetailRequestDtos;

    public OrderDto() {
    }

    public List<OrderDetailRequestDto> getOrderDetailRequestDtos() {
        return orderDetailRequestDtos;
    }

    public void setOrderDetailRequestDtos(List<OrderDetailRequestDto> orderDetailRequestDtos) {
        this.orderDetailRequestDtos = orderDetailRequestDtos;
    }

    public OrderDto(Long id, String status, List<OrderDetailRequestDto> orderDetailRequestDtos) {
        this.id = id;
        this.status = status;
        this.orderDetailRequestDtos = orderDetailRequestDtos;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
