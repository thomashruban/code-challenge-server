package de.code.challenge.game.util;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class GameUtil {

    public int getRandomIntNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }
}
