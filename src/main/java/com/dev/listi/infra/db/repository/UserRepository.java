package com.dev.listi.infra.db.repository;

import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.vo.Email;
import com.dev.listi.infra.db.model.UserModel;
import com.dev.listi.infra.db.repository.panache.UserRepositoryPanache;
import com.dev.listi.infra.db.mapper.UserMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
@Transactional
public class UserRepository implements com.dev.listi.domain.repository.UserRepository {

    @Inject
    UserRepositoryPanache userRepositoryPanache;

    @Inject
    UserMapper userMapper;

    @Override
    public Optional<User> getUser(String name) {
        Optional<UserModel> userModelOptional = userRepositoryPanache.findByName(name);
        User user = userMapper.userModelToUser(userModelOptional.get());
        return Optional.of(user);
    }



    @Override
    public Optional<User> createUser(String name) {
        Email email = new Email("teste@teste.com");
        User user = new User(name, email);
        UserModel userModel = userMapper.userToUserModel(user);
        userRepositoryPanache.persist(userModel);
        return Optional.of(user);
    }

    @Override
    public Optional<User> updateUser(String idUser, String name) {
        return Optional.empty();
    }

    @Override
    public Optional<User> deleteUser(String idUser) {
        return Optional.empty();
    }

    @Override
    public Optional<User> listUsers() {
        return Optional.empty();
    }

    @Override
    public Optional<User> listUser(String idUser) {
        return Optional.empty();
    }

    @Override
    public Optional<User> listUserByName(String name) {
        return Optional.empty();
    }
}
