package com.boldbydevoteam.proximus.proximusbackend.repository;

import com.boldbydevoteam.proximus.proximusbackend.model.entity.CustomerChannels;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CustomerChannelsRepository
        extends ReactiveMongoRepository<CustomerChannels, String> {

    Mono<CustomerChannels> findFirstByCustomerId(String id);
}
