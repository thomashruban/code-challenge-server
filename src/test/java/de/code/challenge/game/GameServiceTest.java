package de.code.challenge.game;

import de.code.challenge.game.model.ResultEnum;
import de.code.challenge.game.model.RoundResultDto;
import de.code.challenge.game.util.GameUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameServiceTest {

    @Mock
    private GameUtil gameUtil;

    @InjectMocks
    GameService gameService;

    @ParameterizedTest
    @CsvSource({"1,0", "2,1", "0,2"})
    public void checkPlayerIsWinning(int playerPick, int computerPick) {
        // setup

        // stubbing
        when(gameUtil.getRandomIntNumber(anyInt())).thenReturn(computerPick);

        // run
        RoundResultDto resultDto = gameService.playRound(playerPick);

        // assert
        assertEquals(ResultEnum.WIN, resultDto.getRoundResult());
    }

    @ParameterizedTest
    @CsvSource({"0,1", "1,2", "2,0"})
    public void checkPlayerIsLosing(int playerPick, int computerPick) {
        // setup

        // stubbing
        when(gameUtil.getRandomIntNumber(anyInt())).thenReturn(computerPick);

        // run
        RoundResultDto resultDto = gameService.playRound(playerPick);

        // assert
        assertEquals(ResultEnum.LOSS, resultDto.getRoundResult());
    }
}