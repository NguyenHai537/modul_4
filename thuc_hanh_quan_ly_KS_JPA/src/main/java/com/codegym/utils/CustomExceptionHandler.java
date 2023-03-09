package com.codegym.utils;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ModelAndView exception2(Exception e){
        System.out.println(e.getMessage());
        ModelAndView modelAndView = new ModelAndView("/error");
        return modelAndView;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ModelAndView exception(IllegalArgumentException e){
        System.out.println(e.getMessage());
        String message = "Da xuat hien loi khong biet";
        ModelAndView modelAndView = new ModelAndView("/error2");
        modelAndView.addObject("message", message);
        return modelAndView;
    }

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView exception(NullPointerException e){
        System.out.println(e.getMessage());
        String message = "Da xuat hien mot loi lien quan den loi trong he thong. Vui long lien he admin thong qua sdt 098745632";
        ModelAndView modelAndView = new ModelAndView("/error2");
        modelAndView.addObject("message", message);
        return modelAndView;
    }



}
