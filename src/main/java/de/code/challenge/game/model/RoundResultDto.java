package de.code.challenge.game.model;

import lombok.Data;

@Data
public class RoundResultDto {

    private int computerPick;
    private ResultEnum roundResult;

}
