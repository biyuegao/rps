package com.xp.rps;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
@Repository
public class InMemoryRepo implements RPSRepository {
    HashMap<Integer, Game> gameHashMap = new HashMap();
    int seq = 0;
    @Override
    public int createGame(Game game) {
        int id = ++seq;
        game.setId(id);
        gameHashMap.put(id, game);
        return id;
    }

    @Override
    public Game getGame(int id) {
        return gameHashMap.get(id);
    }
}
