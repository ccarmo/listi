package com.dev.listi.app.usecases;


import com.dev.listi.app.dto.TransactionRecord;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

public interface ExportCsv {

    Optional<ByteArrayOutputStream> generateCsv(List<TransactionRecord> transactionList);
}
