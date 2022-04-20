package com.novatec.test.services;

import com.novatec.test.models.dto.Response;
import com.novatec.test.models.entities.User;
import com.novatec.test.repositories.UserRepository;
import com.novatec.test.utils.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<Response<List<User>>> findAll() {
        List<User> users = new ArrayList<>();

         return userRepository.findAll()
                .map(users::add)
                .then(Mono.just(new Response<>(HttpStatus.OK.value(), null, users)));
    }

    @Override
    public Mono<Response<User>> get(int id) {
         return userRepository.findById(id)
                 .map(u -> new Response<>(HttpStatus.OK.value(), null, u))
                 .defaultIfEmpty(new Response<>(HttpStatus.NO_CONTENT.value(), ErrorMessage.notFoundById(), null));
    }

    @Override
    public Mono<Response<User>> create(User user) {
        if (user.getId() == 0) {
            user.setId(null);
        }
        return userRepository.save(user)
                .map(u -> new Response<>(HttpStatus.CREATED.value(), null, u));
    }

    @Override
    public Mono<Response<User>> update(int id, User user) {
        return userRepository.findById(id)
                .map(u -> {
                    u.setFirstName(user.getFirstName());
                    u.setLastName(user.getLastName());
                    u.setRole(user.getRole());
                    return userRepository.save(u);
                })
                .flatMap(u -> u)
                .map(u -> new Response<>(HttpStatus.OK.value(), null, u))
                .defaultIfEmpty(new Response<>(HttpStatus.NO_CONTENT.value(), ErrorMessage.notFoundById(), null));
    }

    @Override
    public Mono<Response<User>> delete(int id) {
        return userRepository.findById(id)
                .map(u -> userRepository.delete(u)
                        .thenReturn(new Response<User>(HttpStatus.OK.value(), null, null))
                )
                .flatMap(r -> r)
                .defaultIfEmpty(new Response<>(HttpStatus.NO_CONTENT.value(), ErrorMessage.notFoundById(), null));
    }
}
