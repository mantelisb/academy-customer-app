package com.academy.validation;

import com.academy.exception.ValidationException;

public class CustomerAdultValidator extends Validator<Integer> {
    @Override
    void validate(Integer age) {

        if (age < 18) {
            throw new ValidationException("Customer not adult");
        }
    }
}
