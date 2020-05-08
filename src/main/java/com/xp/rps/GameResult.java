package com.xp.rps;

import java.util.ArrayList;
import java.util.List;

public class GameResult {
    Game game;
    List<Round> roundList = new ArrayList<>();
    Result result;

    public GameResult() {
    }

    public GameResult(Game game, List<Round> roundList) {
        this.game = game;
        this.roundList = roundList;
    }

    public Result getResult() {
        //loop throws list to calculate the final result base on all Rounds
        Result result = Result.DRAW;
        int p1 = 0;
        int p2 = 0;
        for(Round round : roundList) {
            if(round.getResult().equals(Result.P1_WINS)) {
                p1++;
            } else if(round.getResult().equals(Result.P2_WINS)) {
                p2++;
            }
        }
        if(p1 > p2) {
            result = Result.P1_WINS;
        } else if(p1 < p2) {
            result = Result.P2_WINS;
        }
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Round> getRoundList() {
        return roundList;
    }

    public void setRoundList(List<Round> roundList) {
        this.roundList = roundList;
    }
}
