package com.boldbydevoteam.proximus.proximusbackend.controller;

import com.boldbydevoteam.proximus.proximusbackend.model.entity.Customer;
import com.boldbydevoteam.proximus.proximusbackend.model.entity.CustomerChannels;
import com.boldbydevoteam.proximus.proximusbackend.service.CustomerService;
import com.boldbydevoteam.proximus.proximusbackend.service.SubsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping("/customer")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CustomerController {
    private final CustomerService customerService;
    private final SubsService subsService;

    @GetMapping
    public Flux<Customer> allCustomers() {
        return this.customerService.all();
    }

    @GetMapping("/{id}")
    public Mono<Customer> customerById(@PathVariable("id") String id) {
        return this.customerService.get(id);
    }

    @PostMapping
    public Mono<CustomerChannels> registerNewCustomer(@RequestBody Customer customer) {
        return this.subsService.registerNewCustomer(customer);
    }

    @PutMapping("/{id}")
    public Mono<Customer> updateCustomer(@PathVariable("id") String id, @RequestBody Customer customer) {
        return this.customerService.update(id, customer);
    }

    @DeleteMapping("/{id}")
    public Mono<CustomerChannels> deleteCustomer(@PathVariable("id") String id) {
        return this.subsService.delete(id);
    }

}
