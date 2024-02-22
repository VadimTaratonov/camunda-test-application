package ru.taratonov.scoringservice.service;

import ru.taratonov.scoringservice.model.ScoringResponse;

public interface ScoringService {
    ScoringResponse score(Long id);
}
