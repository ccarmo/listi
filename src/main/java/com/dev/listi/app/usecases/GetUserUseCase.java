package com.dev.listi.app.usecases;

import com.dev.listi.app.dto.UserDTO;
import com.dev.listi.domain.entities.User;

import java.util.Optional;

public interface GetUserUseCase {

    Optional<UserDTO> getUser(String email);
}
