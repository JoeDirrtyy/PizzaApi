package com.PizzaApi.PizzaApI.controller;

import com.PizzaApi.PizzaApI.domain.Pizza;
import com.PizzaApi.PizzaApI.repository.CustomerRepository;
import com.PizzaApi.PizzaApI.repository.PizzaRepository;
import com.PizzaApi.PizzaApI.service.PizzaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PizzaController {


    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private PizzaRepository pizzaRepository;

    @PostMapping("/pizza/{customerId}/pizza")
    public Optional<Pizza> createPizza(@PathVariable(value = "customerId") Long customerId, @Validated @RequestBody Pizza pizza){
        return pizzaService.createPizza(customerId,pizza);
    }

    @GetMapping("/pizza/{pizzaId}")
    public Optional<Pizza> getPizzaById(@PathVariable Long pizzaId) {
        return pizzaRepository.findById(pizzaId);
    }

    @GetMapping("/pizza")
    public ResponseEntity<Iterable<Pizza>> getAllPizzas(){
        return pizzaService.getAllPizzas();
    }

    @PutMapping("/pizza/{customerId}/pizza")
    public Optional<Pizza> updatePizza(@PathVariable (value = "customerId") Long customerId, @RequestBody Pizza pizza){
        return pizzaService.updatePizza(customerId,pizza);
    }

    @DeleteMapping("/pizza/{Id}")
    public void deletePizza(@PathVariable Long Id) {
        pizzaService.deletePizza(Id);
    }

    @GetMapping("/searchpizza")
    public Iterable<Pizza> findPizzaByName(@RequestParam("query") String query){
        return pizzaService.findPizzaByName(query);
    }

    @GetMapping("/pizza/{customerId}/pizza")
    public Iterable<Pizza> findByCustomerId(@PathVariable Long customerId){
        return pizzaService.findByCustomerId(customerId);
    }

}

