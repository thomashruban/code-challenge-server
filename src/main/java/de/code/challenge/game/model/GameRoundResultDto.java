package de.code.challenge.game.model;

import lombok.Data;

@Data
public class GameRoundResultDto {

    private int computerPick;
    private ResultEnum roundResult;

}
