package com.dev.listi.user.application.usecase.impl;


import com.dev.listi.user.application.dto.UserRecord;
import com.dev.listi.user.application.usecase.GetUserUseCase;

import com.dev.listi.user.core.entities.User;
import com.dev.listi.user.core.exception.UserNotFoundException;
import com.dev.listi.user.core.repository.UserRepository;
import com.dev.listi.user.infra.db.mapper.UserMapper;
import com.dev.listi.user.infra.db.model.UserModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;

@ApplicationScoped
public class GetUserUseCaseImpl implements GetUserUseCase {

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

    @Override
    public Optional<UserModel> getUserModel(String idUser) {
        Optional<UserModel> userModel = userRepository.getUser(idUser);

        if(userModel.isEmpty()) {
            throw new UserNotFoundException("User not found for number: " + idUser);
        } else {
            return userModel;
        }
    }

    @Override
    public Optional<UserModel> findUserByPhoneNumber(String phoneNumber) {
        return userRepository.findByPhone(phoneNumber);
    }
}
