package ru.taratonov.issueservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.taratonov.issueservice.model.IssueRequest;
import ru.taratonov.issueservice.model.LoanRequest;

@Service
@RequiredArgsConstructor
public class IssueServiceImpl implements IssueService {
    @Value("${custom.url.db.get}")
    private String DB_URL_GET_BY_ID;
    @Value("${custom.url.db.put}")
    private String DB_URL_PUT;
    private final RestTemplate restTemplate;

    @Override
    public void issue(IssueRequest issueRequest) {
        LoanRequest loanRequest = getLoanRequestById(issueRequest.getApplicationId());
        switch (issueRequest.getScoringResponse()) {
            case "issue" -> loanRequest.setResult(true);

            case "noissue" -> loanRequest.setResult(false);

            default -> throw new RuntimeException("not found command");
        }
        restTemplate.put(DB_URL_PUT, loanRequest);
    }

    private LoanRequest getLoanRequestById(Long id) {
        ResponseEntity<LoanRequest> loanRequestResponseEntity =
                restTemplate.getForEntity(DB_URL_GET_BY_ID.replace("{id}", id.toString()), LoanRequest.class);
        if (loanRequestResponseEntity.hasBody()) {
            return loanRequestResponseEntity.getBody();
        } else throw new NullPointerException("response is null");
    }
}
