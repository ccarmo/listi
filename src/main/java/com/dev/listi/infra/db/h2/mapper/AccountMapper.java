package com.dev.listi.infra.db.h2.mapper;

import com.dev.listi.app.dto.AccountDTO;
import com.dev.listi.domain.entities.Account;
import com.dev.listi.infra.db.h2.model.AccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface AccountMapper {


    Account accountModelToAccount(AccountModel accountModel);

    AccountDTO accountModelToAccountDTO(AccountModel accountModel);

    AccountModel accountToAccountModel(Account account);
}
