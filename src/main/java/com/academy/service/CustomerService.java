package com.academy.service;

import com.academy.entity.Customer;
import com.academy.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private Validator validator;


    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void insert(Customer customer) {
        validator.validate(customer);

        customer.setFirstName(capitalizeFirstLetter(customer.getFirstName()));
        customer.setLastName(capitalizeFirstLetter(customer.getLastName()));
        customer.setPersonalNumber(formatPersonalNumber(customer));

        customerRepository.insert(customer);
    }

    private String capitalizeFirstLetter(String string) {
        if (string.isEmpty()) {
            return string;
        } else {
            return String.valueOf(string.charAt(0)).toUpperCase() + string.substring(1);
        }
    }

    private String formatPersonalNumber(Customer customer) {
        if (customer.getPersonalNumber().length() < 5) {
            return customer.getPersonalNumber();
        } else {
            return customer.getPersonalNumber().substring(0, 4) + "-" + customer.getPersonalNumber().substring(4);
        }
    }

    public void deleteById(String customerId) {
        customerRepository.deleteById(customerId);
    }
}
