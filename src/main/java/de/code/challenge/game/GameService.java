package de.code.challenge.game;

import de.code.challenge.game.model.RoundResultDto;
import de.code.challenge.game.model.ResultEnum;
import de.code.challenge.game.util.GameUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameUtil gameUtil;

    public RoundResultDto playRound(int playerPick) {

        int computerPick = gameUtil.getRandomIntNumber(3);
        ResultEnum result = determineWinner(playerPick, computerPick);

        RoundResultDto resultDto = new RoundResultDto();
        resultDto.setComputerPick(computerPick);
        resultDto.setRoundResult(result);

        return resultDto;
    }

    private ResultEnum determineWinner(int playerPick, int computerPick) {
        if (playerPick == computerPick) {
            return ResultEnum.TIE;
        }

        if ((playerPick - computerPick + 3) % 3 == 1) {
            return ResultEnum.WIN;
        }

        return ResultEnum.LOSS;
    }
}
