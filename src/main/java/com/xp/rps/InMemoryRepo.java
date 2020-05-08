package com.xp.rps;

import org.springframework.stereotype.Repository;

import java.util.HashMap;

//@Repository
public class InMemoryRepo implements RPSRepository {
    HashMap<Integer, Game> gameHashMap = new HashMap();
    HashMap<Integer, GameResult> gameResultHashMap = new HashMap<>();
    int seq = 0;
    @Override
    public int createGame(Game game) {
        int id = ++seq;
        game.setId(id);
        gameHashMap.put(id, game);
        GameResult gameResult = new GameResult();
        gameResult.setGame(game);
        gameResultHashMap.put(id,gameResult);
        return id;
    }

    @Override
    public Game getGame(int id) {
        return gameHashMap.get(id);
    }

    @Override
    public void createGameResult(int id, GameResult gameResult) {
        gameResultHashMap.put(id, gameResult);
    }

    @Override
    public GameResult getGameResult(int id) {
        return gameResultHashMap.get(id);
    }

}
