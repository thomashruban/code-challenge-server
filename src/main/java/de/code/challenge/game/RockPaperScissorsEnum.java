package de.code.challenge.game;

import java.util.*;

public enum RockPaperScissorsEnum {
    ROCK,
    PAPER,
    SCISSORS;

    private static final RockPaperScissorsEnum[] values = values();
    private static final Random random = new Random();

    public static RockPaperScissorsEnum getRandomPick(){
        return values[random.nextInt(values.length)];
    }
}
