package com.dev.listi.app.usecases;

import com.dev.listi.usermanagement.domain.User;

import java.util.Optional;


public interface CreateUserUseCase {
    
    Optional<User> createUser(User user);
}
