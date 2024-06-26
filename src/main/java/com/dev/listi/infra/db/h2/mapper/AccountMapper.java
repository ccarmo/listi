package com.dev.listi.infra.db.h2.mapper;

import com.dev.listi.app.dto.AccountDTO;
import com.dev.listi.app.dto.AccountRecord;
import com.dev.listi.domain.entities.Account;
import com.dev.listi.domain.entities.TypeAccount;
import com.dev.listi.infra.db.h2.model.AccountModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "cdi")
public interface AccountMapper {


    @Mapping(source = "accountModel.typeAccount", target = "typeAccount", qualifiedByName = "mapStringToTypeAccount")
    Account accountModelToAccount(AccountModel accountModel);

    AccountRecord accountModelToAccountRecord(AccountModel accountModel);

    AccountRecord accountToAccountRecord(Account account);

    @Mapping(source = "account.typeAccount", target = "typeAccount", qualifiedByName = "mapTypeAccountToString")
    AccountModel accountToAccountModel(Account account);

    @Named("mapStringToTypeAccount")
    default TypeAccount mapStringToTypeAccount(String typeAccount) {
        return TypeAccount.of(typeAccount);
    }

    @Named("mapTypeAccountToString")
    default String mapTypeAccountToString(TypeAccount typeAccount) {
        return typeAccount.toString();
    }
}
