package com.novatec.test.repositories;

import com.novatec.test.models.entities.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
}
