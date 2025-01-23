package com.dev.listi.usermanagement.domain.repository;


import com.dev.listi.usermanagement.domain.User;

import java.util.Optional;

public interface UserRepository {

    Optional<User> getUser(String idUser);

    Optional<User> createUser(String name);
}
