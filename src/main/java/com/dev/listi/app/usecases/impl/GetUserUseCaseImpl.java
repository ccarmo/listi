package com.dev.listi.app.usecases.impl;

import com.dev.listi.app.dto.UserDTO;
import com.dev.listi.app.usecases.GetUserUseCase;
import com.dev.listi.domain.entities.User;
import com.dev.listi.infra.db.h2.repository.UserRepositoryH2;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class GetUserUseCaseImpl implements GetUserUseCase {

    @Inject
    UserRepositoryH2 userRepositoryH2;

    @Override
    public Optional<UserDTO> getUser(String email) {
        return userRepositoryH2.getUser(email);
    }
}
