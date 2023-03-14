package com.academy.service;

import com.academy.entity.CountryCode;
import com.academy.entity.Customer;
import com.academy.exception.CustomerNotAdultException;
import com.academy.exception.InvalidCountryCodeException;
import com.academy.exception.MandatoryValueMissingException;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    public void validate(Customer customer) {
        if (customer.getPersonalNumber().isBlank()) {
            throw new MandatoryValueMissingException("Missing personal number");
        }
        if (customer.getFirstName().isBlank()) {
            throw new MandatoryValueMissingException("Missing first name");
        }
        if (customer.getLastName().isBlank()) {
            throw new MandatoryValueMissingException("Missing last name");
        }
        if (customer.getAge() < 18) {
            throw new CustomerNotAdultException("Customer is not adult, age is: " + customer.getAge());
        }
        if (!customer.getCountryCode().isEmpty()) {
            try {
                CountryCode.valueOf(customer.getCountryCode().toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new InvalidCountryCodeException("Country code: %s, is not valid".formatted(customer.getCountryCode()));
            }
        }
    }
}
