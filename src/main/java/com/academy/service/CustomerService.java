package com.academy.service;

import com.academy.entity.Customer;
import com.academy.repository.CustomerRepository;
import com.academy.repository.MemoryCustomerRepository;

import java.util.List;

public class CustomerService {

    private CustomerRepository repository = new MemoryCustomerRepository();
    private Validator validator = new Validator();


    public List<Customer> findAll() {
        return repository.findAll();
    }

    public void insert(Customer customer) {
        validator.validate(customer);

        customer.setFirstName(capitalizeFirstLetter(customer.getFirstName()));
        customer.setLastName(capitalizeFirstLetter(customer.getLastName()));
        customer.setPersonalNumber(formatPersonalNumber(customer.getPersonalNumber()));

        repository.insert(customer);
    }

    private String formatPersonalNumber(String personalNumber) {
        if (personalNumber == null || personalNumber.length() <= 4) {
            return personalNumber;
        } else {
            return String.format("%s-%s", personalNumber.substring(0, 4), personalNumber.substring(4));
        }
    }

    private String capitalizeFirstLetter(String string) {
        if (string == null || string.isEmpty()) {
            return string;
        } else {
            return string.substring(0, 1).toUpperCase() + string.substring(1);
        }
    }

    public void deleteById(String customerId) {
        repository.deleteById(customerId);
    }
}
