package com.dev.listi.app.usecases.impl;

import com.dev.listi.app.dto.UserRecord;
import com.dev.listi.app.usecases.CreateUser;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.repository.UserRepository;
import com.dev.listi.infra.db.mapper.UserMapper;
import com.dev.listi.infra.db.model.UserModel;
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
        Optional<UserModel> userModel = userRepository.createUser(name);
        User user = userMapper.userModelToUser(userModel.get());
        UserRecord userRecord = userMapper.userToUserDTO(user);
        return Optional.of(userRecord);
    }
}
