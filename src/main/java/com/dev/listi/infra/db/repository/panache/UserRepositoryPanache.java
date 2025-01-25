package com.dev.listi.infra.db.repository.panache;

import com.dev.listi.infra.db.model.UserModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class UserRepositoryPanache implements PanacheRepository<UserModel> {
    public Optional<UserModel> findByName(String username) {
        return find("username", username).firstResultOptional();
    }

    public Optional<UserModel> findByEmail(String email) {
        return find("email", email).firstResultOptional();
    }

    public Optional<UserModel> createUser(UserModel userModel) {
        persist(userModel);
        return Optional.of(userModel);
    }

    public Optional<UserModel> updateUser(Long idUser, String name) {
        UserModel userModel = findById(idUser);
        if (userModel != null) {
            userModel.setName(name);
            persist(userModel);
            return Optional.of(userModel);
        }
        return Optional.empty();
    }

    public Optional<UserModel> deleteUser(Long idUser) {
        Optional<UserModel> userModel = findByIdOptional(idUser);
        userModel.ifPresent(this::delete);
        return userModel;
    }

    public List<UserModel> listUsers() {
        return listAll();
    }

    public Optional<UserModel> listUser(Long idUser) {
        return findByIdOptional(idUser);
    }

    public Optional<UserModel> listUserByName(String name) {
        return find("name", name).firstResultOptional();
    }




}
