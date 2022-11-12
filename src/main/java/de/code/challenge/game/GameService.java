package de.code.challenge.game;

import de.code.challenge.game.model.GameRoundResultDto;
import de.code.challenge.game.model.ResultEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameService {

    public GameRoundResultDto playRound(int playerPick) {

        int computerPick = getRandomPick();
        ResultEnum result = determineWinner(playerPick, computerPick);

        GameRoundResultDto resultDto = new GameRoundResultDto();
        resultDto.setComputerPick(computerPick);
        resultDto.setRoundResult(result);

        return resultDto;
    }

    private ResultEnum determineWinner(int playerPick, int computerPick) {
        int resultAbs = Math.abs(computerPick - playerPick);
        switch (resultAbs) {
            case 0:
                return ResultEnum.TIE;
            case 1:
                return ResultEnum.LOSS;
            default:
                return ResultEnum.WIN;
        }
    }

    public int getRandomPick() {
        Random random = new Random();
        return random.nextInt(2) + 1;
    }

}
