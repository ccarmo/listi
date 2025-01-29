package com.dev.listi.domain.repository;


import com.dev.listi.domain.entities.User;
import com.dev.listi.infra.db.model.UserModel;

import java.util.Optional;

public interface UserRepository {

    Optional<UserModel> getUser(String idUser);

    Optional<UserModel> getUserById(String idUser);

    Optional<UserModel> createUser(String name);

    Optional<UserModel> findByEmail(String email);

    Optional<UserModel> updateUser(String idUser, String name);

    Optional<UserModel> deleteUser(String idUser);

    Optional<UserModel> listUsers();

    Optional<UserModel> listUser(String idUser);

    Optional<UserModel> listUserByName(String name);

}
