package com.codegym.validator;

import com.codegym.dto.CustomerDto;
//import com.codegym.dto.PhoneDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PhoneValidator implements Validator {

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return PhoneValidator.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String number = customerDto.getNumber();
        ValidationUtils.rejectIfEmpty(errors , "number" , "number.empty");
        if (number.length() > 11 || number.length() <10){
            errors.rejectValue("number" , "number.length");
        }
        if (!number.startsWith("0")){
            errors.rejectValue("number" , "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number", "number.matches");
        }

    }
}
