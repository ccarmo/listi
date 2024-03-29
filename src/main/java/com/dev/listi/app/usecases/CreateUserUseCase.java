package com.dev.listi.app.usecases;

import com.dev.listi.domain.entities.User;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;


public interface CreateUserUseCase {
    
    Optional<User> createUser(User user);
}
