package com.dev.listi.app.dto;



import com.dev.listi.domain.entities.TypeTransaction;

import java.math.BigDecimal;

public record TransactionRecord(String accountNumber, BigDecimal valueTransaction, TypeTransaction typeTransaction) {
}
