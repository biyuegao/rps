package com.xp.rps;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RpsApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	TestRestTemplate restTemplate;

	@Test
	//Rest convention - if doing CRUD
	void createGame() {
		ResponseEntity<Integer> responseEntity = restTemplate.postForEntity("/game",
				new Game("BiYue","Jeremy", 3), Integer.class);
		int id = responseEntity.getBody();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(responseEntity.getBody()>0);
		ResponseEntity<Game> responseEntity1 = restTemplate.getForEntity("/game/"+id, Game.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("BiYue", responseEntity1.getBody().getPlayer1());

		ResponseEntity<Round> round = restTemplate.postForEntity("/play/1", new Round(Throw.PAPER, Throw.ROCK, null), Round.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals(Result.P1_WINS, round.getBody().getResult());

		ResponseEntity<GameResult> gameResult = restTemplate.getForEntity("/gameresult/1", GameResult.class);
		assertEquals(HttpStatus.OK, gameResult.getStatusCode());
		assertEquals(Result.P1_WINS, gameResult.getBody().result);

	}
}
