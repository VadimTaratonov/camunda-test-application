package ru.taratonov.scoringservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import ru.taratonov.scoringservice.model.ScoringResponse;
import ru.taratonov.scoringservice.service.ScoringService;

@RestController
@RequiredArgsConstructor
public class ScoringController implements ScoringApi {
    private final ScoringService scoringService;

    @Override
    public ScoringResponse score(Long id) {
        return scoringService.score(id);
    }
}
