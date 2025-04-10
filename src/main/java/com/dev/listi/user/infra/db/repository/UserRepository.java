package com.dev.listi.user.infra.db.repository;

import com.dev.listi.user.core.entities.User;
import com.dev.listi.shared.core.vo.Email;
import com.dev.listi.user.infra.db.mapper.UserMapper;
import com.dev.listi.user.infra.db.model.UserModel;
import com.dev.listi.user.infra.db.panache.UserRepositoryPanache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
public class UserRepository implements com.dev.listi.user.core.repository.UserRepository {

    @Inject
    UserRepositoryPanache userRepositoryPanache;

    @Inject
    UserMapper userMapper;

    @Override
    @Transactional
    public Optional<UserModel> getUser(String name) {
        return userRepositoryPanache.findByName(name);
    }

    @Override
    @Transactional
    public Optional<UserModel> getUserById(String idUser) {
        return userRepositoryPanache.findByIdOptional(Long.valueOf(idUser));
    }



    @Override
    @Transactional
    public Optional<UserModel> createUser(String name) {
        Email email = new Email("teste@teste.com");
        User user = new User(name, email);
        UserModel userModel = userMapper.userToUserModel(user);
        userRepositoryPanache.persist(userModel);
        return Optional.of(userModel);
    }

    @Override
    public Optional<UserModel> findByEmail(String email) {
        Optional<UserModel> userModel = userRepositoryPanache.findByEmail(email);
        return userModel;
    }

    @Override
    public Optional<UserModel> updateUser(String idUser, String name) {
        return Optional.empty();
    }

    @Override
    public Optional<UserModel> deleteUser(String idUser) {
        return Optional.empty();
    }

    @Override
    public Optional<UserModel> listUsers() {
        return Optional.empty();
    }

    @Override
    public Optional<UserModel> listUser(String idUser) {
        return Optional.empty();
    }

    @Override
    public Optional<UserModel> listUserByName(String name) {
        return Optional.empty();
    }
}
