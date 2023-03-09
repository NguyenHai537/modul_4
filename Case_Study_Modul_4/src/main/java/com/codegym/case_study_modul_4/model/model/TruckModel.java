package com.codegym.case_study_modul_4.model.model;

import java.io.Serializable;

public class TruckModel implements Serializable {
    private String name;
    private String licensePlates;
    private Long weight;

    public TruckModel(String name, String licensePlates, Long weight) {
        this.name = name;
        this.licensePlates = licensePlates;
        this.weight = weight;
    }

    public TruckModel() {
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
}
