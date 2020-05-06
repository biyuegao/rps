package com.xp.rps;

public class RPS {

    public static Result play(Throw t1, Throw t2) {
        if(t1 == t2) {
            return Result.DRAW;
        } else if(t1 == Throw.ROCK) {
            if(t2 == Throw.PAPER) {
                return Result.P2_WINS;
            } else if(t2 == Throw.SCISSORS) {
                return Result.P1_WINS;
            }
        } else if(t1 == Throw.PAPER) {
            if(t2 == Throw.ROCK) {
                return Result.P1_WINS;
            } else if(t2 == Throw.SCISSORS) {
                return Result.P2_WINS;
            }
        } else if(t1 == Throw.SCISSORS) {
            if(t2 == Throw.ROCK) {
                return Result.P2_WINS;
            } else if(t2 == Throw.PAPER) {
                return Result.P1_WINS;
            }
        }
        return null;
    }
}
