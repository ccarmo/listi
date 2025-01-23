package com.dev.listi.infra.db.repository.panache;

import com.dev.listi.infra.db.model.UserModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class UserRepositoryPanache implements PanacheRepository<UserModel> {
    public Optional<UserModel> findByName(String username) {
        return find("username", username).firstResultOptional();
    }
}
