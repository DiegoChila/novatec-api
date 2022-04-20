package com.novatec.test.services;

import com.novatec.test.models.dto.Response;
import com.novatec.test.models.entities.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface IUserService {
    Mono<Response<List<User>>> findAll();
    Mono<Response<User>> get(int id);
    Mono<Response<User>> create(User user);
    Mono<Response<User>> update(int id, User user);
    Mono<Response<User>> delete(int id);

}
