package com.academy.service;

import com.academy.entity.CountryCode;
import com.academy.entity.Customer;
import com.academy.exception.CustomerNotAdultException;
import com.academy.exception.InvalidCountryCodeException;
import com.academy.exception.MandatoryValueMissingException;

public class Validator {

    public void validate(Customer customer) {
        validateMandatoryFields(customer);

        validateCountryCode(customer.getCountryCode());
    }

    private void validateCountryCode(String countryCode) {
        if (countryCode != null && !countryCode.isEmpty()) {
            try {
                CountryCode.valueOf(countryCode);
            } catch (IllegalArgumentException e) {
                throw new InvalidCountryCodeException(countryCode);
            }
        }
    }

    private void validateMandatoryFields(Customer customer) {
        if (!isValidString(customer.getFirstName())) {
            throw new MandatoryValueMissingException("Missing first name");
        }

        if (!isValidString(customer.getLastName())) {
            throw new MandatoryValueMissingException("Missing last name");
        }

        if (!isValidString(customer.getPersonalNumber())) {
            throw new MandatoryValueMissingException("Missing personal number");
        }

        if (customer.getAge() < 18) {
            throw new CustomerNotAdultException();
        }
    }

    private boolean isValidString(String string) {
        return string != null && !string.trim().isEmpty();
    }
}
