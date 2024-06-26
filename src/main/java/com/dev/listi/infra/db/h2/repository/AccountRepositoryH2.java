package com.dev.listi.infra.db.h2.repository;

import com.dev.listi.app.dto.AccountDTO;
import com.dev.listi.domain.entities.Account;
import com.dev.listi.domain.repository.AccountRepository;
import com.dev.listi.infra.db.h2.mapper.AccountMapper;
import com.dev.listi.infra.db.h2.model.AccountModel;
import com.dev.listi.infra.db.h2.repository.panache.AccountRepositoryPanache;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

@ApplicationScoped
@Transactional
public class AccountRepositoryH2 implements AccountRepository {

    @Inject
    AccountMapper accountMapper;

    @Inject
    AccountRepositoryPanache accountRepositoryPanache;

    @Override
    public Optional<Account> getAccountNumber(String accountNumber) {
        Optional<AccountModel> accountModel = accountRepositoryPanache.findByAccountNumber(accountNumber);
        Account account = accountMapper.accountModelToAccount(accountModel.get());
        return Optional.of(account);
    }

    @Override
    public Optional<Account> updatedAccount(Account account) {
        return Optional.empty();
    }


    @Override
    public Optional<Account> createAccount(Account account) {
        AccountModel accountModel = accountMapper.accountToAccountModel(account);
        accountRepositoryPanache.persist(accountModel);
        return Optional.of(accountMapper.accountModelToAccount(accountModel));
    }

}
