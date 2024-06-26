package com.dev.listi.infra.db.h2.repository.panache;

import com.dev.listi.infra.db.h2.model.AccountModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class AccountRepositoryPanache implements PanacheRepository<AccountModel> {

    public Optional<AccountModel> findByAccountNumber(String accountNumber) {
        return find("accountNumber", accountNumber).firstResultOptional();
    }
}
