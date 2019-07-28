package com.boldbydevoteam.proximus.proximusbackend.repository;

import com.boldbydevoteam.proximus.proximusbackend.model.entity.Customer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository
        extends ReactiveMongoRepository<Customer, String> {

}
