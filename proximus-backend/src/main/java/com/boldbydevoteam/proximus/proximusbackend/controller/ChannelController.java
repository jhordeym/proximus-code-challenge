package com.boldbydevoteam.proximus.proximusbackend.controller;

import com.boldbydevoteam.proximus.proximusbackend.model.entity.Channel;
import com.boldbydevoteam.proximus.proximusbackend.service.ChannelService;
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
@RequestMapping("/channel")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChannelController {
    private final ChannelService channelService;

    @GetMapping
    public Flux<Channel> all() {
        return this.channelService.all();
    }

    @GetMapping("/{id}")
    public Mono<Channel> byId(@PathVariable("id") String id) {
        return this.channelService.get(id);
    }

    @PostMapping
    public Mono<Channel> save(@RequestBody Channel channel) {
        return this.channelService.create(channel);
    }

    @PutMapping("/{id}")
    public Mono<Channel> update(@PathVariable("id") String id, @RequestBody Channel channel) {
        return this.channelService.update(id, channel);
    }

    @DeleteMapping("/{id}")
    public Mono<Channel> delete(@PathVariable("id") String id) {
        return this.channelService.delete(id);
    }

}
