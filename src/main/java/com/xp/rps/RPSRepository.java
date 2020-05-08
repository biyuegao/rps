package com.xp.rps;

public interface RPSRepository {
    int createGame(Game game);
    Game getGame(int id);
    void createGameResult(int id, GameResult gameResult);
    GameResult getGameResult(int id);
}
