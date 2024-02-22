package ru.taratonov.dbservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.taratonov.dbservice.model.LoanRequest;

import java.util.List;

public interface DbApi {
    @GetMapping("/all")
    List<LoanRequest> getAllRequests();

    @GetMapping("/{id}")
    LoanRequest getRequestById(@PathVariable Long id);

    @PostMapping("/add")
    Long addRequest(@RequestBody LoanRequest loanRequest);

    @PutMapping("/update")
    void update(@RequestBody LoanRequest loanRequest);
}
