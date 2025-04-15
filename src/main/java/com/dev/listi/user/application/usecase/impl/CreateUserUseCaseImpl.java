package com.dev.listi.user.application.usecase.impl;

import com.dev.listi.user.application.dto.UserRecord;
import com.dev.listi.user.application.usecase.CreateUserUseCase;
import com.dev.listi.user.core.entities.User;
import com.dev.listi.user.core.repository.UserRepository;
import com.dev.listi.user.infra.db.mapper.UserMapper;
import com.dev.listi.user.infra.db.model.UserModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    @Inject
    UserRepository userRepository;

    @Inject
    UserMapper userMapper;

    @Override
    public Optional<UserRecord> createUser(String name, String phone, String email) {
        Optional<UserModel> userModel = userRepository.createUser(name, phone, email);
        User user = userMapper.userModelToUser(userModel.get());
        UserRecord userRecord = userMapper.userToUserDTO(user);
        return Optional.of(userRecord);
    }
}
