package de.code.challenge.game;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

    public RockPaperScissorsEnum getRandomPick() {
        return RockPaperScissorsEnum.getRandomPick();
    }

}
