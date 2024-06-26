package com.dev.listi.app.usecases;



import com.dev.listi.app.dto.AccountRecord;

import java.util.Optional;

public interface CreateAccount {

    Optional<AccountRecord> createAccount(AccountRecord accountRecord);
}
