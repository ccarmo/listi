package com.dev.listi.domain.repository;


import com.dev.listi.app.dto.UserDTO;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.vo.Email;

import java.util.Optional;

public interface UserRepository {

    Optional<UserDTO> getUser(String email);

    Optional<User> createUser(User user);
}
