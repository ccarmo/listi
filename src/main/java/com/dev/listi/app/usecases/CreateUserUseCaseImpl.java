package com.dev.listi.app.usecases;

import com.dev.listi.domain.entities.User;
import com.dev.listi.infra.db.h2.repository.UserRepositoryH2;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;
@ApplicationScoped
public class CreateUserUseCaseImpl implements CreateUserUseCase{

    @Inject
    UserRepositoryH2 userRepositoryH2;
    @Override
    public Optional<User> createUser(User user) {
        return userRepositoryH2.createUser(user);
    }
}
