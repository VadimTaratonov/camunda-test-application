package ru.taratonov.dbservice.service;

import ru.taratonov.dbservice.model.LoanRequest;

import java.util.List;

public interface DbService {
    List<LoanRequest> getAll();

    LoanRequest getRequestById(Long id);

    Long add(LoanRequest loanRequest);

    void update(LoanRequest loanRequest);
}
