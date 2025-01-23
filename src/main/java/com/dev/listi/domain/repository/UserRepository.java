package com.dev.listi.domain.repository;


import com.dev.listi.domain.entities.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getUser(String idUser);

    Optional<User> createUser(String name);

    Optional<User> updateUser(String idUser, String name);

    Optional<User> deleteUser(String idUser);

    Optional<User> listUsers();

    Optional<User> listUser(String idUser);

    Optional<User> listUserByName(String name);

}
