package ru.taratonov.scoringservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.taratonov.scoringservice.model.ScoringResponse;

public interface ScoringApi {
    @PostMapping("/scoring")
    ScoringResponse score(@RequestBody Long id);
}
