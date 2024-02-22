package ru.taratonov.issueservice.service;

import ru.taratonov.issueservice.model.IssueRequest;

public interface IssueService {
    void issue(IssueRequest issueRequest);
}
