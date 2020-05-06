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
//	@Mock
//	RPSRepository repository;

	@Test
	//Rest convention - if doing CRUD
	void createGame() {
		ResponseEntity<Integer> responseEntity = restTemplate.postForEntity("/game",
				new Game("BiYue","Jeremy", 3), Integer.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertTrue(responseEntity.getBody()>0);
		ResponseEntity<Game> responseEntity1 = restTemplate.getForEntity("/game/1", Game.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		assertEquals("BiYue", responseEntity1.getBody().getPlayer1());
	}
	@Test
	void getGame() {
//		Game g = new Game("Biyue", "Jeremy",3);
//		when(repository.getGame(any())).thenReturn(g);
		ResponseEntity<Game> responseEntity = restTemplate.getForEntity("/game/1", Game.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
		System.out.println(responseEntity.getBody());
//		verify(repository).getGame(any());
	}

}
