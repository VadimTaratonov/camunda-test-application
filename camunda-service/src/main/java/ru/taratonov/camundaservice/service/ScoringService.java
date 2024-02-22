package ru.taratonov.camundaservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.taratonov.camundaservice.model.LoanRequest;
import ru.taratonov.camundaservice.model.ScoringResponse;

@Service
@RequiredArgsConstructor
public class ScoringService {
    private final RestTemplate restTemplate;

    @Value("${custom.url.scoring}")
    private String scoringServiceUrl;

    public double doScoring(Long applicationId) {
        ScoringResponse response = restTemplate.postForObject(scoringServiceUrl, applicationId, ScoringResponse.class);
        return response != null ? response.getScore() : 0.0;
    }

}

