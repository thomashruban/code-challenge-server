package de.code.challenge.game;

import de.code.challenge.game.model.RoundResultDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void shouldLoadGameRoundResult() throws Exception {
        ResponseEntity<RoundResultDto> responseEntity = this.restTemplate.withBasicAuth("user", "password").getForEntity("http://localhost:" + port + "/api/v1/rockPaperScissors/game/round/play?player-pick={playerPick}", RoundResultDto.class, "0");
        RoundResultDto resultDto = responseEntity.getBody();

        assertNotNull(resultDto);
        assertSame(responseEntity.getStatusCode(), HttpStatus.OK);
        assertTrue(resultDto.getComputerPick() <= 2);
    }

    @Test
    public void shouldBlockRequestUnauthorized() throws Exception {
        ResponseEntity<RoundResultDto> responseEntity = this.restTemplate.getForEntity("http://localhost:" + port + "/api/v1/rockPaperScissors/game/round/play?player-pick={playerPick}", RoundResultDto.class, "0");
        RoundResultDto resultDto = responseEntity.getBody();

        assertNull(resultDto);
        assertSame(responseEntity.getStatusCode(), HttpStatus.UNAUTHORIZED);
    }

    @Test
    public void shouldBlockRequestBadRequest() throws Exception {
        ResponseEntity<RoundResultDto> responseEntity = this.restTemplate.withBasicAuth("user", "password").getForEntity("http://localhost:" + port + "/api/v1/rockPaperScissors/game/round/play", RoundResultDto.class);
        RoundResultDto resultDto = responseEntity.getBody();

        assertNull(resultDto);
        assertSame(responseEntity.getStatusCode(), HttpStatus.BAD_REQUEST);
    }
}