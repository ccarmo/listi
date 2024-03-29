package com.dev.listi.domain.repository;



import com.dev.listi.domain.entities.Statement;

import java.util.List;

public interface StatementRepository {

    void savedStatement(Statement statement);
    List<Statement> getStatementAccount(String idAccount);
}
