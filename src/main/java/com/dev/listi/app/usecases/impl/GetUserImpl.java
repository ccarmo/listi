package com.dev.listi.app.usecases.impl;


import com.dev.listi.app.dto.UserRecord;
import com.dev.listi.app.usecases.GetUser;

import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.exceptions.UserNotFoundException;
import com.dev.listi.domain.repository.UserRepository;
import com.dev.listi.infra.db.h2.mapper.UserMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class GetUserImpl implements GetUser {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Override
    public Optional<UserRecord> getUser(String idUser) {
        Optional<User> user = userRepository.getUser(idUser);
        UserRecord userRecord = userMapper.userToUserDTO(user.get());
        if(user.isEmpty()) {
            throw new UserNotFoundException("User not found for number: " + idUser);
        } else {
            return Optional.of(userRecord);
        }
    }
}
