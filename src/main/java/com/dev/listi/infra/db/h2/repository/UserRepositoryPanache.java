package com.dev.listi.infra.db.h2.repository;

import com.dev.listi.infra.db.h2.model.UserModel;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserRepositoryPanache implements PanacheRepositoryBase<UserModel, String> {
}
