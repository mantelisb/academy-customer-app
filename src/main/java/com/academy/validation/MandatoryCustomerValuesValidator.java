package com.academy.validation;

import com.academy.entity.Customer;
import com.academy.exception.ValidationException;

public class MandatoryCustomerValuesValidator extends Validator<Customer> {

    @Override
    void validate(Customer customer) {
        if (!isValidString(customer.getFirstName())) {
            throw new ValidationException("Missing first name");
        }

        if (!isValidString(customer.getLastName())) {
            throw new ValidationException("Missing last name");
        }

        if (!isValidString(customer.getPersonalNumber())) {
            throw new ValidationException("Missing personal number");
        }
    }

    private boolean isValidString(String string) {
        return string != null && !string.trim().isEmpty();
    }
}
