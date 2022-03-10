package com.academy.validation;

import com.academy.entity.Customer;

public class CustomerValidator {

    public void validate(Customer customer) {
        new MandatoryCustomerValuesValidator().validate(customer);
        new CountryCodeValidator().validate(customer.getCountryCode());
        new CustomerAdultValidator().validate(customer.getAge());
    }

}
