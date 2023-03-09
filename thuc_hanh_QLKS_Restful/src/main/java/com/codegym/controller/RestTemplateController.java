package com.codegym.controller;


import com.codegym.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RestTemplateController {

    @GetMapping("/view/{id}")
    public ModelAndView viewCustomer(@PathVariable Long id ){
        ModelAndView modelAndView = new ModelAndView("/homePage");
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject("http://localhost:8080/api/customers/" + id, Customer.class);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }
}
