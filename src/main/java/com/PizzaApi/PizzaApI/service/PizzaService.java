package com.PizzaApi.PizzaApI.service;

import com.PizzaApi.PizzaApI.domain.Pizza;
import com.PizzaApi.PizzaApI.repository.CustomerRepository;
import com.PizzaApi.PizzaApI.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import java.util.Optional;

@Service
public class PizzaService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PizzaRepository pizzaRepository;

    public Optional<Pizza> createPizza(Long customerId, Pizza pizza) {
        return customerRepository.findById(customerId).map(customer -> {
            pizza.setCustomer(customer);
            return pizzaRepository.save(pizza);
        });
    }

        public void deletePizza(Long id) {
            pizzaRepository.deleteById(id);
        }

    public ResponseEntity<Iterable<Pizza>> getAllPizzas(){
        Iterable<Pizza> allPizzas = pizzaRepository.findAll();
        return new ResponseEntity<>(pizzaRepository.findAll(), HttpStatus.OK);
    }

    public Optional<Pizza> updatePizza(Long customerId, Pizza pizza) {
        return customerRepository.findById(customerId).map(customer -> {
            pizza.setCustomer(customer);
            return pizzaRepository.save(pizza);
        });
    }

    public  Iterable<Pizza> findPizzaByName(String query){
        return pizzaRepository.findPizzaByName(query);
    }

    public  Iterable<Pizza> findByCustomerId(Long customerId){
        return pizzaRepository.findByCustomerId(customerId);
    }



}
