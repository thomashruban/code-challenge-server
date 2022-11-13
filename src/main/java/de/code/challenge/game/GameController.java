package de.code.challenge.game;

import de.code.challenge.game.model.RoundResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@Log4j2
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("api/v1/game/rock-paper-scissors/round/play")
    public ResponseEntity<RoundResultDto> getRandomPick(
            @RequestParam(name = "player-pick") int playerPick) {
        return ResponseEntity.ok(gameService.playRound(playerPick));
    }
}
