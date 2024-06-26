package com.dev.listi.app.usecases;


import com.dev.listi.app.dto.AccountRecord;

import java.util.Optional;


public interface GetAccount {
    Optional<AccountRecord> getAccount(String idAccount);
}
