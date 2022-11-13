package de.code.challenge.game;

import de.code.challenge.game.model.RoundResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@Log4j2
@RequiredArgsConstructor
public class GameController {

    private final GameService gameService;

    @GetMapping("api/v1/rockPaperScissor/game/round/play")
    public ResponseEntity<RoundResultDto> getRandomPick(
            @RequestParam(name = "player-pick") int playerPick) {
        return ResponseEntity.ok(gameService.playRound(playerPick));
    }

    @PostMapping("api/v1/rockPaperScissors/game/round/store")
    public ResponseEntity<String> storeGameResult() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
