package com.codegym.controller;


import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import com.codegym.model.Province;
import com.codegym.service.ICustomerService;
import com.codegym.service.IProvinceService;
import com.codegym.validator.PhoneValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IProvinceService provinceService;

    @ModelAttribute("provinces")
    public Iterable<Province> provinces() {
        return provinceService.findAll();
    }

    @GetMapping("/createcustomer")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }

    @PostMapping("/create-customer")
    public ModelAndView saveCustomer(@ModelAttribute("customerDto") CustomerDto customerDto,
                                     BindingResult bindingResult) {
//        new PhoneValidator().validate(customerDto, bindingResult);

        if (bindingResult.hasErrors()){
            return new ModelAndView ("/create");
        }
        customerService.save(customerDto);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("customer", new CustomerDto());
        modelAndView.addObject("message", "New customer created successfully");
        return modelAndView;
    }



    @GetMapping("/customers")
    public ModelAndView listCustomer(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                                     @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                                     @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                                     @RequestParam("search") Optional<String> search, Pageable pageable) {
        Page<CustomerDto> customers ;
        pageable = PageRequest.of(page, size);
        if (search.isPresent()){
            customers = customerService.findAllByFirstNameContaining(search.get(),pageable);
        }else {
            customers = customerService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/list");
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("/edit-customer/{id}")
    public ModelAndView showEditForm(@PathVariable Long id){
        Optional<CustomerDto> customer = customerService.findById(id);
        if ( customer != null){
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-customer")
    public ModelAndView updateCustomer(@ModelAttribute("customer") CustomerDto customer) {
        customerService.save(customer);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("customer", customer);
        modelAndView.addObject("message", "Customer updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-customer/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id){
        Optional<CustomerDto> customer = customerService.findById(id);
        if(customer != null){
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("customer", customer.get());
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-customer")
    public String deleteCustomer(@ModelAttribute("customer") Customer customer){
        customerService.remove(customer.getId());
        return "redirect:customers";
    }
}
