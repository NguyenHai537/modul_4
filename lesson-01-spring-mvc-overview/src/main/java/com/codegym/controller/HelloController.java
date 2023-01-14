package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public ModelAndView getHomapage(){
        ModelAndView modelAndView = new ModelAndView("/index.html");
        return modelAndView;
    }
}
