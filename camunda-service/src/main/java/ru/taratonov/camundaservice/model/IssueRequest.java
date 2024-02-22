package ru.taratonov.camundaservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueRequest {
    private Long applicationId;
    private String scoringResponse;
}
