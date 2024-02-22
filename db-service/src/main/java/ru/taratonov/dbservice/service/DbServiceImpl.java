package ru.taratonov.dbservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.taratonov.dbservice.model.LoanRequest;
import ru.taratonov.dbservice.repository.DbRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DbServiceImpl implements DbService {
    private final DbRepository dbRepository;

    @Override
    public List<LoanRequest> getAll() {
        return dbRepository.findAll();
    }

    @Override
    public LoanRequest getRequestById(Long id) {
        return dbRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("not found request"));
    }

    @Override
    public Long add(LoanRequest loanRequest) {
        return dbRepository.save(loanRequest).getId();
    }

    @Override
    public void update(LoanRequest loanRequest) {
        dbRepository.save(loanRequest);
    }
}
