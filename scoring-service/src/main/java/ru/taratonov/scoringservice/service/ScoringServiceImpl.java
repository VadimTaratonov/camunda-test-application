package ru.taratonov.scoringservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.taratonov.scoringservice.model.LoanRequest;
import ru.taratonov.scoringservice.model.ScoringResponse;

@Service
@RequiredArgsConstructor
public class ScoringServiceImpl implements ScoringService {

    @Value("${custom.url.db.get}")
    private String DB_URL;
    private final RestTemplate restTemplate;
    @Override
    public ScoringResponse score(Long id) {
        LoanRequest loanRequest = getLoanRequestById(id);
        double rate = 0;
        if (loanRequest.getAge() > 25 && loanRequest.getAge() < 60) {
            rate += 250;
        }
        if (loanRequest.getDependentAmount() <= 1) {
            rate += 200;
        }
        if (loanRequest.getSalary() > 50000) {
            rate += 200;
        }
        return new ScoringResponse(rate);
    }

    private LoanRequest getLoanRequestById(Long id) {
        ResponseEntity<LoanRequest> loanRequestResponseEntity = restTemplate.getForEntity(DB_URL.replace("{id}", id.toString()), LoanRequest.class);
        if (loanRequestResponseEntity.hasBody()){
            return loanRequestResponseEntity.getBody();
        } else throw new NullPointerException("response is null");
    }
}
