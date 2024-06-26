package com.dev.listi.infra.db.h2.repository;

import com.dev.listi.app.dto.UserDTO;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.repository.UserRepository;
import com.dev.listi.domain.vo.Email;
import com.dev.listi.infra.db.h2.mapper.UserMapper;
import com.dev.listi.infra.db.h2.model.UserModel;
import com.dev.listi.infra.db.h2.repository.panache.UserRepositoryPanache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
@Transactional
public class UserRepositoryH2 implements UserRepository {

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
