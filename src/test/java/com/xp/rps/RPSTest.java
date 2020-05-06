package com.xp.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPSTest {
    @Test
    void rockVsPaper() {
        assertEquals(Result.P2_WINS, RPS.play(Throw.ROCK, Throw.PAPER));
    }
    @Test
    void rockVsScissors() {
        assertEquals(Result.P1_WINS, RPS.play(Throw.ROCK, Throw.SCISSORS));
    }
    @Test
    void paperVsScissors() {
        assertEquals(Result.P2_WINS, RPS.play(Throw.PAPER, Throw.SCISSORS));
    }
    @Test
    void paperVsRock() {
        assertEquals(Result.P1_WINS, RPS.play(Throw.PAPER, Throw.ROCK));
    }
    @Test
    void ScissorsVsPaper() {
        assertEquals(Result.P1_WINS, RPS.play(Throw.SCISSORS, Throw.PAPER));
    }
    @Test
    void scissorsVsRock() {
        assertEquals(Result.P2_WINS, RPS.play(Throw.SCISSORS, Throw.ROCK));
    }
    @Test
    void rockVsRock() {
        assertEquals(Result.DRAW, RPS.play(Throw.ROCK, Throw.ROCK));
    }
    @Test
    void papersPaper() {
        assertEquals(Result.DRAW, RPS.play(Throw.PAPER, Throw.PAPER));
    }
    @Test
    void scissorsVsScissors() {
        assertEquals(Result.DRAW, RPS.play(Throw.SCISSORS, Throw.SCISSORS));
    }
}
