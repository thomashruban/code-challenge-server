package de.code.challenge.game.util;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class GameUtil {

    public int getRandomIntNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
