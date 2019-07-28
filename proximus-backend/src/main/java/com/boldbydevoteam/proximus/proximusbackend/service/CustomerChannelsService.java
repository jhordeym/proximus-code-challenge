package com.boldbydevoteam.proximus.proximusbackend.service;

import com.boldbydevoteam.proximus.proximusbackend.model.entity.CustomerChannels;
import com.boldbydevoteam.proximus.proximusbackend.repository.CustomerChannelsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerChannelsService implements CrudService<CustomerChannels> {
    private final CustomerChannelsRepository customerChannelsRepository;

    @Override
    public Flux<CustomerChannels> all() {
        return this.customerChannelsRepository.findAll();
    }

    @Override
    public Mono<CustomerChannels> get(final String id) {
        return this.customerChannelsRepository.findById(id);
    }

    @Override
    public Mono<CustomerChannels> create(final CustomerChannels customerChannels) {
        return this.customerChannelsRepository.save(customerChannels);
    }

    @Override
    public Mono<CustomerChannels> update(final String id, CustomerChannels customerChannels) {
        return this.customerChannelsRepository.findById(id).map(cc -> {
            customerChannels.setId(cc.getId());
            return customerChannels;
        }).flatMap(this.customerChannelsRepository::save);
    }

    @Override
    public Mono<CustomerChannels> delete(final String id) {
        return this.customerChannelsRepository.findById(id)
                                      .flatMap(c -> this.customerChannelsRepository.deleteById(c.getId()).thenReturn(c));
    }

    public Mono<CustomerChannels> findFirstByCustomerId(final String id) {
        return this.customerChannelsRepository.findFirstByCustomerId(id);
    }
}
