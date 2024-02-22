package ru.taratonov.camundaservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkerHelper {
    private final ScoringService scoringService;
    private final LoanIssueService loanIssueService;

    public Object syncExecuteTask(String operationCode, Map<String, Object> variables) {
        Integer applicationId = Integer.parseInt(variables.getOrDefault("applicationId", "").toString());
        return switch (operationCode) {
            case "scoring" -> scoringService.doScoring(applicationId.longValue());
            case "result" -> loanIssueService.issue(applicationId.longValue(), variables.getOrDefault("scoringResponse", "").toString());
            default -> throw new RuntimeException("Unknown operationCode");
        };
    }

}
