package com.boldbydevoteam.proximus.proximusbackend.controller;

import java.util.List;
import java.util.Objects;

import com.boldbydevoteam.proximus.proximusbackend.model.entity.Channel;
import com.boldbydevoteam.proximus.proximusbackend.model.entity.CustomerChannels;
import com.boldbydevoteam.proximus.proximusbackend.service.SubsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin("*")
@RequestMapping("/subs")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SubsController {
    private final SubsService subsService;

    @PostMapping("/subscribe/{customerId}")
    public Mono<CustomerChannels> subscribe(
            @PathVariable("customerId") String customerId,
            @RequestBody List<String> newChannels,
            @RequestParam(value = "append", required=false) Boolean append) {
        if(Objects.isNull(append))
            append = Boolean.FALSE;
        return this.subsService.subscribeToNewChannels(customerId, newChannels, append);
    }

    @GetMapping("/subbed/{customerId}")
    public Flux<Channel> allSubbed(@PathVariable("customerId") String id){
        return this.subsService.findAllSubbed(id);
    }

    @GetMapping("/available/{customerId}")
    public Flux<Channel> allAvailable(@PathVariable("customerId") String id){
        return this.subsService.findAllAvailable(id);
    }

}
