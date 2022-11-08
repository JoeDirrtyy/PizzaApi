package com.PizzaApi.PizzaApI.repository;

import com.PizzaApi.PizzaApI.domain.Pizza;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza,Long> {
    @Query(value = "select * from pizza where name LIKE concat('%',:query,'%')", nativeQuery = true)
    Iterable<Pizza> findPizzaByName(String query);

    Iterable<Pizza> findByCustomerId(Long customerId);
}
