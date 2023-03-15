package com.academy.service;

import com.academy.entity.CountryCode;
import com.academy.entity.Customer;
import com.academy.exception.CustomerNotAdultException;
import com.academy.exception.InvalidCountryCodeException;
import com.academy.exception.MandatoryValueMissingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CustomerValidator {

    @Autowired
    @Qualifier("adultValidator")
    private Validator<Integer> customerAdultValidator;
    @Autowired
    @Qualifier("mandatoryFieldsValidator")
    private Validator<Customer> mandatoryCustomerValuesValidator;
    @Autowired
    @Qualifier("countryCodeValidator")
    private Validator<String> countryCodeValidator;
    public void validate(Customer customer) {
        mandatoryCustomerValuesValidator.validate(customer);
        customerAdultValidator.validate(customer.getAge());
        countryCodeValidator.validate(customer.getCountryCode());

    }
}
