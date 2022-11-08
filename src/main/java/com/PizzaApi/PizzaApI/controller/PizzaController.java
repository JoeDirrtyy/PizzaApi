package com.PizzaApi.PizzaApI.controller;

import com.PizzaApi.PizzaApI.domain.Pizza;
import com.PizzaApi.PizzaApI.repository.CustomerRepository;
import com.PizzaApi.PizzaApI.repository.PizzaRepository;
import com.PizzaApi.PizzaApI.service.PizzaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PizzaController {


    @Autowired
    private PizzaService pizzaService;

    @Autowired
    private PizzaRepository pizzaRepository;

    @PostMapping("/pizzas/{customerId}/pizzas")
    public Optional<Pizza> createPizza(@PathVariable(value = "categoryId") Long customerId, @RequestBody Pizza pizza){
        return pizzaService.createPizza(customerId,pizza);
    }

    @GetMapping("/pizzas{pizzaId}")
    public Optional<Pizza> getPizzaById(@PathVariable Long pizzaId) {
        return pizzaRepository.findById(pizzaId);
    }

    @GetMapping("/pizzas")
    public ResponseEntity<Iterable<Pizza>> getAllPizzas(){
        return pizzaService.getAllPizzas();
    }

    @PutMapping("/pizzas/{customerId}/pizzas")
    public Optional<Pizza> updatePizza(@PathVariable (value = "customerId") Long customerId, @RequestBody Pizza pizza){
        return pizzaService.updatePizza(customerId,pizza);
    }

    @DeleteMapping("/pizzas/{Id}")
    public void deletePizza(@PathVariable Long Id) {
        pizzaService.deletePizza(Id);
    }

    @GetMapping("/searchpizzas")
    public Iterable<Pizza> findPizzaByName(@RequestParam("query") String query){
        return pizzaService.findPizzaByName(query);
    }

    @GetMapping("/pizzas/{customerId}/pizzas")
    public Iterable<Pizza> findByCustomerId(@PathVariable Long customerId){
        return pizzaService.findByCustomerId(customerId);
    }

}

