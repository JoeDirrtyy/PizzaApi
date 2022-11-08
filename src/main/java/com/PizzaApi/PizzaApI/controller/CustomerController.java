package com.PizzaApi.PizzaApI.controller;


import com.PizzaApi.PizzaApI.domain.Customer;
import com.PizzaApi.PizzaApI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customer")
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @GetMapping("/customer")
    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PutMapping("/customer/{customerId}")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long customerId) {
        return customerService.updateCustomer(customer, customerId);
    }

    @DeleteMapping("/customer/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<?> getCustomerById(@PathVariable Long customerId) {
        return customerService.getCustomerById(customerId);
    }


}
