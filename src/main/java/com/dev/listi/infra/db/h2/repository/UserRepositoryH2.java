package com.dev.listi.infra.db.h2.repository;

import com.dev.listi.app.dto.UserDTO;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.repository.UserRepository;
import com.dev.listi.infra.db.h2.mapper.UserMapper;
import com.dev.listi.infra.db.h2.model.UserModel;
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
    public Optional<UserDTO> getUser(String email) {
        UserModel userModel = userRepositoryPanache.find("email = ?1", email).firstResult();
        UserDTO userDTO = userMapper.userModelToUserDTO(userModel);
        return Optional.of(userDTO);
    }

    @Override
    public Optional<User> createUser(User user) {
         UserModel userModel = userMapper.userToUserModel(user);
         userRepositoryPanache.persist(userModel);
         return Optional.ofNullable(userMapper.userModelToUser(userModel));
    }
}
