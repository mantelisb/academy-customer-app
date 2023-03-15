package com.academy.service;

import com.academy.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component("adultValidator")
public class CustomerAdultValidator extends Validator<Integer> {
    @Override
    public void validate(Integer age) {
        if (age < 18) {
            throw new ValidationException("Customer is not adult, age is: " + age);
        }
    }
}
