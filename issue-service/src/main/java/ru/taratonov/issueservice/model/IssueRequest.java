package ru.taratonov.issueservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueRequest {
    private Long applicationId;
    private String scoringResponse;
}
