package com.dev.listi.app.usecases;

import com.dev.listi.app.dto.UserDTO;

import java.util.Optional;

public interface GetUserUseCase {

    Optional<UserDTO> getUser(String email);
}
