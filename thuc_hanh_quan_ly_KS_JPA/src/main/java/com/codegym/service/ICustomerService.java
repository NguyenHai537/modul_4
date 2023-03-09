package com.codegym.service;

import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<CustomerDto> {
    Page<CustomerDto> findAll(Pageable pageable) ;

    Page<CustomerDto> findAllByFirstNameContaining(String firstname, Pageable pageable);


}
