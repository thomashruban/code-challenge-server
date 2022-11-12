package de.code.challenge.game;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@Log4j2
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("api/v1/rockPaperScissor/game/round/play")
    public ResponseEntity<RockPaperScissorsEnum> getRandomPick() {
        return ResponseEntity.ok(gameService.getRandomPick());
    }

    @PostMapping("api/v1/rockPaperScissors/game/round/store")
    public ResponseEntity<String> storeGameResult() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
