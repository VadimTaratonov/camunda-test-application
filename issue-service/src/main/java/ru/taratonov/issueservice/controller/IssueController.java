package ru.taratonov.issueservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import ru.taratonov.issueservice.model.IssueRequest;
import ru.taratonov.issueservice.service.IssueService;
import ru.taratonov.issueservice.service.IssueServiceImpl;

@RestController
@RequiredArgsConstructor
@Slf4j
public class IssueController implements IssueApi {
    private final IssueService issueService;

    @Override
    public void issue(IssueRequest issueRequest) {
        issueService.issue(issueRequest);
    }
}
