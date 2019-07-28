package com.boldbydevoteam.proximus.proximusbackend.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CrudService<T> {
    Flux<T> all();
    Mono<T> get(String id);
    Mono<T> create(T t);
    Mono<T> update(String id, T t);
    Mono<T> delete(String id);
}
