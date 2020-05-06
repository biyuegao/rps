package com.xp.rps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPSRepositoryTest {
    RPSRepository repository;
    @BeforeEach
    void setUp() {
        repository = new InMemoryRepo();
    }

    @Test
    void createGame() {
        Game g = new Game("Biyue", "Jeremy",3);
        int id = repository.createGame(g);
        assertEquals(1, id);
    }
    @Test
    void getGame() {
        Game g = new Game("Biyue", "Jeremy",3);
        int id = repository.createGame(g);
        Game game = repository.getGame(id);
        assertEquals("Biyue", game.getPlayer1());
        assertEquals("Jeremy", game.getPlayer2());
    }
}
