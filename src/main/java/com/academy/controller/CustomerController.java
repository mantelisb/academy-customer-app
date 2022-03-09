package com.academy.controller;

import com.academy.entity.Customer;
import com.academy.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService service = new CustomerService();

    public CustomerController() {
        
    }

    @RequestMapping("/customer/all")
    public List<Customer> fetchCustomers() {
        return service.findAll();
    }

    @PostMapping("/customer/insert")
    public void insertCustomer(@RequestBody Customer customer) {
        service.insert(customer);
    }

    @DeleteMapping("/customer/delete/{customerId}")
    public void deleteCustomer(@PathVariable String customerId) {
        service.deleteById(customerId);
    }
}