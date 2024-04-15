package com.dev.listi.infra.db.h2.repository;

import com.dev.listi.domain.entities.Account;
import com.dev.listi.infra.db.h2.model.AccountModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class AccountRepositoryPanache implements PanacheRepository<AccountModel> {
}
