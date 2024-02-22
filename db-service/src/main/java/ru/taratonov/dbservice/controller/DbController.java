package ru.taratonov.dbservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.taratonov.dbservice.model.LoanRequest;
import ru.taratonov.dbservice.service.DbService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DbController implements DbApi {
    private final DbService dbService;

    @Override
    public List<LoanRequest> getAllRequests() {
        return dbService.getAll();
    }

    @Override
    public LoanRequest getRequestById(Long id) {
        return dbService.getRequestById(id);
    }

    @Override
    public Long addRequest(LoanRequest loanRequest) {
        return dbService.add(loanRequest);
    }

    @Override
    public void update(LoanRequest loanRequest) {
        dbService.update(loanRequest);
    }
}
