package com.dev.listi.app.usecases.impl;


import com.dev.listi.app.dto.UserRecord;
import com.dev.listi.app.usecases.GetUser;

import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.exceptions.UserNotFoundException;
import com.dev.listi.domain.repository.UserRepository;
import com.dev.listi.infra.db.mapper.UserMapper;
import com.dev.listi.infra.db.model.UserModel;
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
        Optional<UserModel> userModel = userRepository.getUser(idUser);

        if(userModel.isEmpty()) {
            throw new UserNotFoundException("User not found for number: " + idUser);
        } else {
            User user = userMapper.userModelToUser(userModel.get());
            UserRecord userRecord = userMapper.userToUserDTO(user);
            return Optional.of(userRecord);
        }
    }
}
