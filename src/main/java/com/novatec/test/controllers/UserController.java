package com.novatec.test.controllers;

import com.novatec.test.models.dto.Response;
import com.novatec.test.models.entities.User;
import com.novatec.test.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public Mono<Response<List<User>>> findAll() {
        return userService.findAll();
    }

    @PostMapping
    public Mono<Response<User>> save(@RequestBody @Valid User user) {
        return userService.create(user);
    }

    @GetMapping("/{id}")
    public Mono<Response<User>> get(@PathVariable int id) {
        return userService.get(id);
    }

    @PutMapping("/{id}")
    public Mono<Response<User>> update(@PathVariable int id, @RequestBody @Valid User user) {
        return userService.update(id, user);
    }

    @DeleteMapping("/{id}")
    public Mono<Response<User>> delete(@PathVariable int id) {
        return userService.delete(id);
    }
}
