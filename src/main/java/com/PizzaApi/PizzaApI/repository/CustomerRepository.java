package com.PizzaApi.PizzaApI.repository;

import com.PizzaApi.PizzaApI.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
