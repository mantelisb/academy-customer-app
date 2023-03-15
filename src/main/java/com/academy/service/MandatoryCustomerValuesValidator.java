package com.academy.service;

import com.academy.entity.Customer;
import com.academy.exception.ValidationException;
import org.springframework.stereotype.Component;

@Component("mandatoryFieldsValidator")
public class MandatoryCustomerValuesValidator extends Validator<Customer> {
    @Override
    public void validate(Customer customer) {
        if (customer.getPersonalNumber().isBlank()) {
            throw new ValidationException("Missing personal number");
        }
        if (customer.getFirstName().isBlank()) {
            throw new ValidationException("Missing first name");
        }
        if (customer.getLastName().isBlank()) {
            throw new ValidationException("Missing last name");
        }
    }
}
