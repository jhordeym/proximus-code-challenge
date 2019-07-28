package com.boldbydevoteam.proximus.proximusbackend.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.boldbydevoteam.proximus.proximusbackend.model.entity.Channel;
import com.boldbydevoteam.proximus.proximusbackend.model.entity.Customer;
import com.boldbydevoteam.proximus.proximusbackend.model.entity.CustomerChannels;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class SubsService {
    private final CustomerService customerService;
    private final ChannelService channelService;
    private final CustomerChannelsService customerChannelsService;

    public Mono<CustomerChannels> registerNewCustomer(Customer customer) {
        return this.customerService.create(customer)
                                   .then(Mono.just(customer))
                                   .flatMap(this::generateCC);
    }

    private Mono<CustomerChannels> generateCC(final Customer c) {
        return this.channelService.allDefault()
                                         .map(Channel::getId)
                                         .collectList()
                                         .map(channels -> CustomerChannels.builder().customerId(c.getId()).activeChannels(channels).build())
                                         .flatMap(this.customerChannelsService::create);
    }

    public Mono<CustomerChannels> subscribeToNewChannels(String customerId, List<String> newList, Boolean append) {
        return this.customerChannelsService.findFirstByCustomerId(customerId)
                                           .flatMap(cc -> this.customerChannelsService.update(cc.getId(),
                                                   CustomerChannels.builder()
                                                                   .customerId(customerId)
                                                                   .activeChannels(append ? updateListOfChannels(cc.getActiveChannels(), newList) : newList)
                                                                   .build()));

    }

    private List<String> updateListOfChannels(final List<String> oldList, final List<String> newList) {
        return Stream.concat(oldList.stream(), newList.stream()).distinct().collect(Collectors.toList());
    }

    public Flux<Channel> findAllSubbed(final String customerId) {
        return this.customerChannelsService
                .findFirstByCustomerId(customerId)
                .flatMapMany(cc -> this.channelService.allByIdIn(cc.getActiveChannels()));
    }

    public Flux<Channel> findAllAvailable(final String customerId) {
        return this.customerChannelsService
                .findFirstByCustomerId(customerId)
                .flatMapMany(cc -> this.channelService.allByIdNotIn(cc.getActiveChannels()));
    }

    public Mono<CustomerChannels> delete(final String id) {
        return this.customerService.delete(id)
                                   .flatMap( (Customer customer) -> this.customerChannelsService.findFirstByCustomerId(id))
                                   .flatMap( (CustomerChannels cc) -> this.customerChannelsService.delete(cc.getId()));
    }
}
