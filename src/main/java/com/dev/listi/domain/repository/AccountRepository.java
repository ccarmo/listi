package com.dev.listi.domain.repository;



import com.dev.listi.app.dto.AccountDTO;
import com.dev.listi.domain.entities.Account;

import java.util.Optional;

public interface AccountRepository {
    Optional<AccountDTO> getAccount(String accountNumber);
    Optional<Account> createAccount(Account account);
}
