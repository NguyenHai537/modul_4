package com.codegym.service;

import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.repository.ICustomerRepository;
//import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Iterable<CustomerDto> findAll() {
        Iterable<Customer> customers = customerRepository.findAll();
        List<Customer> customerList =
                StreamSupport.stream(customers.spliterator(), false)
                        .collect(Collectors.toList());

        return customerList.stream()
                .map( customer -> modelMapper.map( customer, CustomerDto.class ))
                .collect( Collectors.toList());

    }

    @Override
    public Optional<CustomerDto> findById(Long id)  {
        Optional<Customer> customer = customerRepository.findById(id);

         return Optional.ofNullable(modelMapper.map(customer,CustomerDto.class)) ;
    }

    @Override
    public void save(CustomerDto customerDto) {
        customerDto = null;
        Customer customer = modelMapper.map(customerDto, Customer.class);
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    private Page<CustomerDto> toCustomerPageDto(Page<Customer> customerPage) {
        return customerPage.map(this::convertToCustomerDto);
    }

    private CustomerDto convertToCustomerDto(Customer customer) {
        return modelMapper.map(customer, CustomerDto.class);
    }

    @Override
    public Page<CustomerDto> findAll(Pageable pageable)  {
        Page<Customer> customers = customerRepository.findAll(pageable);
        return toCustomerPageDto(customers);
    }

    @Override
    public Page<CustomerDto> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        Page<Customer> customers = customerRepository.findAllByFirstNameContaining(firstname,pageable);
        return toCustomerPageDto(customers);
    }

    public Iterable<Customer> findAllByProvince(Province province) {
        return customerRepository.findAllByProvince(province);
    }
}
