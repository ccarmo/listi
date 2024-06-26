package com.dev.listi.domain.repository;


import com.dev.listi.domain.entities.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getUser(String idUser);

    Optional<User> createUser(String name);
}
