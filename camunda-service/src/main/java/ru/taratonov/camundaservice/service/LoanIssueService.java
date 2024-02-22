package ru.taratonov.camundaservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.taratonov.camundaservice.model.IssueRequest;

@Service
@RequiredArgsConstructor
public class LoanIssueService {
    private final RestTemplate restTemplate;

    @Value("${custom.url.issue}")
    private String issueServiceUrl;

    public String issue(Long id, String scoringResponse) {
        IssueRequest request = new IssueRequest(id,scoringResponse);
        restTemplate.postForEntity(issueServiceUrl, request, Void.class);
        return "";
    }
}
