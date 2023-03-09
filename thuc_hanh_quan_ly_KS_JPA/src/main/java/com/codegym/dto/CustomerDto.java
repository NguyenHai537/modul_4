package com.codegym.dto;

import com.codegym.model.Province;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class CustomerDto {

    private Long id;

//    @NotEmpty(message = "Khong duoc de trong")
//    @Size(min = 1 , max = 255, message = "Do dai khong hop le")
    private String firstName;
//    @Size(min = 1 , max = 255, message = "Do dai khong hop le")
//    @NotEmpty(message = "Khong duoc de trong")
    private String lastName;

    private Province province;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }


//    @Size(min = 10 , max = 11 , message = "Sdt khong hop le")
    private String number;

    public CustomerDto(Long id, String firstName, String lastName, Province province, String number) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.province = province;
        this.number = number;
    }

    public CustomerDto() {}

    public CustomerDto(String firstName, String lastName,String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", province=" + province +
                ", number='" + number + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
