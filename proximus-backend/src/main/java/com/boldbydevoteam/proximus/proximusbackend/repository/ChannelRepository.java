package com.boldbydevoteam.proximus.proximusbackend.repository;

import java.util.List;

import com.boldbydevoteam.proximus.proximusbackend.model.entity.Channel;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ChannelRepository
        extends ReactiveMongoRepository<Channel, String> {

    Flux<Channel> findAllByActiveByDefaultIsTrue();
    Flux<Channel> findByIdIn(List<String> ids);
    Flux<Channel> findByIdNotIn(List<String> ids);
}
