package com.dev.listi.app.services.api;

import com.dev.listi.app.dto.UserDTO;
import com.dev.listi.app.usecases.CreateUserUseCase;
import com.dev.listi.app.usecases.GetUserUseCase;
import com.dev.listi.domain.entities.User;
import com.dev.listi.domain.vo.Email;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Optional;

@ApplicationScoped
public class UserService {
    @Inject
    CreateUserUseCase createUserUseCase;

    @Inject
    GetUserUseCase getUserUseCase;


    public Response createUser() {
        Email email = new Email("carmo@teste.com");
        User user = new User("Carmo", email);
        Optional<User> userOptional = createUserUseCase.createUser(user);
        return Response.ok(userOptional.get()).build();
    }

    public Response getUser(@QueryParam("email") String email) {
        Optional<UserDTO> user = getUserUseCase.getUser(email);
        return Response.ok(user.get()).build();
    }
}
