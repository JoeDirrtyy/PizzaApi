package com.PizzaApi.PizzaApI.service;

import com.PizzaApi.PizzaApI.domain.Customer;
import com.PizzaApi.PizzaApI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public ResponseEntity<Customer> createCustomer(Customer customer){
        customerRepository.save(customer);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}").buildAndExpand(customer.getId()).toUri();
        responseHeaders.setLocation(newPollUri);
        return new ResponseEntity<>(null,responseHeaders, HttpStatus.CREATED);
    }
    public ResponseEntity<Iterable<Customer>> getAllCustomers(){
        Iterable<Customer> allCustomers = customerRepository.findAll();
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<?> updateCustomer(Customer customer, Long customerId) {
        verifyCustomer(customerId);
        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> deleteCustomer( Long customerId) {
        customerRepository.deleteById(customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<?> getCustomerById( Long categoryId) {
        Optional<Customer> c = customerRepository.findById(categoryId);
        return new ResponseEntity<> (c, HttpStatus.OK);
    }
    protected void verifyCustomer(Long customerId){
        Optional<Customer> c = customerRepository.findById(customerId);
    }

}
