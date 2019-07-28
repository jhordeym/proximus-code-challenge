package com.boldbydevoteam.proximus.proximusbackend.service;

import com.boldbydevoteam.proximus.proximusbackend.model.entity.Customer;
import com.boldbydevoteam.proximus.proximusbackend.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerService implements CrudService<Customer> {
    private final CustomerRepository customerRepository;

    @Override
    public Flux<Customer> all() {
        return this.customerRepository.findAll();
    }

    @Override
    public Mono<Customer> get(final String id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public Mono<Customer> create(final Customer customer) {
        return this.customerRepository.save(customer);
    }

    @Override
    public Mono<Customer> update(final String id, Customer customer) {
        return this.customerRepository.findById(id)
                                      .map(c -> {
                                          customer.setId(c.getId());
                                          return customer;
                                      })
                                      .flatMap(this.customerRepository::save);
    }

    @Override
    public Mono<Customer> delete(final String id) {
        return this.customerRepository.findById(id)
                                      .flatMap(c -> this.customerRepository.deleteById(c.getId()).thenReturn(c));
    }
}
