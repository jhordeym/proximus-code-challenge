package com.boldbydevoteam.proximus.proximusbackend.service;

import java.util.List;

import com.boldbydevoteam.proximus.proximusbackend.model.entity.Channel;
import com.boldbydevoteam.proximus.proximusbackend.repository.ChannelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ChannelService implements CrudService<Channel> {
    private final ChannelRepository channelRepository;

    @Override
    public Flux<Channel> all() {
        return this.channelRepository.findAll();
    }

    @Override
    public Mono<Channel> get(final String id) {
        return this.channelRepository.findById(id);
    }

    @Override
    public Mono<Channel> create(final Channel channel) {
        return this.channelRepository.save(channel);
    }

    @Override
    public Mono<Channel> update(final String id, Channel channel) {
        return this.channelRepository.findById(id)
                                     .map(c -> {
                                         channel.setId(c.getId());
                                         return channel;
                                     })
                                     .flatMap(this.channelRepository::save);
    }

    @Override
    public Mono<Channel> delete(final String id) {
        return this.channelRepository.findById(id)
                                     .flatMap(c -> this.channelRepository.deleteById(c.getId()).thenReturn(c));
    }

    public Flux<Channel> allDefault() {
        return this.channelRepository.findAllByActiveByDefaultIsTrue();
    }
    public Flux<Channel> allByIdIn(List<String> ids) {
        return this.channelRepository.findByIdIn(ids);
    }
    public Flux<Channel> allByIdNotIn(List<String> ids) {
        return this.channelRepository.findByIdNotIn(ids);
    }

}
