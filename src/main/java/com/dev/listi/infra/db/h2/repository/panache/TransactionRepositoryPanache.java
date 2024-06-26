package com.dev.listi.infra.db.h2.repository.panache;

import com.dev.listi.infra.db.h2.model.AccountModel;
import com.dev.listi.infra.db.h2.model.TransactionModel;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class TransactionRepositoryPanache implements PanacheRepository<TransactionModel> {

    public List<TransactionModel> findAllByAccountNumber(String accountNumber) {
        return find("accountNumber", accountNumber).stream().toList();
    }
}
