package com.dev.listi.user.core.repository;


import com.dev.listi.user.infra.db.model.UserModel;

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
