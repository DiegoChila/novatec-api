package com.novatec.test.controllers;

import com.novatec.test.models.dto.Response;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationControllerAdvice {

    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<Response<Object>> validationException(WebExchangeBindException e) {
        List<String> errors = e.getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        return Mono.just(new Response<>(HttpStatus.BAD_REQUEST.value(), (ArrayList<String>) errors, null));
    }
}
