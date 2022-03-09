package com.academy.controller;

import com.academy.entity.Customer;
import com.academy.repository.CustomerRepository;
import com.academy.repository.MemoryCustomerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MainController {

    private CustomerRepository repository = new MemoryCustomerRepository();

    public MainController() {
        
    }

    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers() {
        return repository.findAll();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) {
        repository.insert(customer);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        repository.deleteById(customerId);
    }
}