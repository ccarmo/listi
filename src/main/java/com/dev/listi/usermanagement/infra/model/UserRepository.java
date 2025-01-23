package com.dev.listi.usermanagement.infra.model;

import com.dev.listi.usermanagement.domain.User;
import com.dev.listi.ordermanagement.domain.vo.Email;
import com.dev.listi.usermanagement.mapper.UserMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
@Transactional
public class UserRepository implements com.dev.listi.usermanagement.domain.repository.UserRepository {

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
}
