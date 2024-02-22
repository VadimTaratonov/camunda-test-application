package ru.taratonov.issueservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.taratonov.issueservice.model.IssueRequest;

public interface IssueApi {
    @PostMapping("/issue")
    void issue(@RequestBody IssueRequest issueRequest);
}
