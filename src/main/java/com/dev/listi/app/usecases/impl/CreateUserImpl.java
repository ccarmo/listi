package com.dev.listi.app.usecases.impl;

import com.dev.listi.app.dto.UserRecord;
import com.dev.listi.app.usecases.CreateUser;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.repository.UserRepository;
import com.dev.listi.infra.db.h2.mapper.UserMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;
@ApplicationScoped
public class CreateUserImpl implements CreateUser {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Override
    public Optional<UserRecord> createUser(String name) {
        Optional<User> user = userRepository.createUser(name);
        return  Optional.of(userMapper.userToUserDTO(user.get()));
    }
}
