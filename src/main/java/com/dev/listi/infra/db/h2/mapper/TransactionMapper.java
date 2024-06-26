package com.dev.listi.infra.db.h2.mapper;


import com.dev.listi.app.dto.TransactionRecord;
import com.dev.listi.domain.entities.Transaction;
import com.dev.listi.domain.entities.TypeTransaction;
import com.dev.listi.infra.db.h2.model.TransactionModel;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "cdi", builder = @Builder)
public interface TransactionMapper {

    @Mapping(source = "transaction.typeTransaction", target = "typeTransaction", qualifiedByName = "mapTypeTransactionToString")
    TransactionModel transactionToTransactionModel(Transaction transaction);
    @Mapping(source = "transactionModel.typeTransaction", target = "typeTransaction", qualifiedByName = "mapStringToTypeTransaction")
    @Mapping(source = "transactionModel.valueTransaction", target = "value")
    Transaction transactionModelToTransaction(TransactionModel transactionModel);

    TransactionRecord transactionToTransactionRecord(Transaction transaction);

    @Named("mapStringToTypeTransaction")
    default TypeTransaction mapStringToTypeTransaction(String typeTransaction) {
        return TypeTransaction.of(typeTransaction);
    }

    @Named("mapTypeTransactionToString")
    default String mapTypeTransactionToString(TypeTransaction typeTransaction) {
        return typeTransaction.toString();
    }
}
