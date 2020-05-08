package com.xp.rps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JdbcRepositoryTest {
    JDBCRepository jdbcRepository;

    @BeforeEach
    public void setUp() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setURL("jdbc:postgresql://arjuna.db.elephantsql.com:5432/mwzdwjrx?user=mwzdwjrx&password=yicxxQjCrufs3ug5iy8HigLsAwvcFpIS");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcRepository = new JDBCRepository(jdbcTemplate);
    }

    @Test
    @Disabled
    public void test_getGameResult() {
        Game game = new Game( "Tom", "Kate", 3);
        int id = jdbcRepository.createGame(game);
        assertTrue(id>0);
        Round round1 = new Round(Throw.PAPER, Throw.ROCK, Result.P1_WINS);
        Round round2 = new Round(Throw.SCISSORS, Throw.PAPER, Result.P1_WINS);
        Round round3 = new Round(Throw.SCISSORS, Throw.ROCK, Result.P2_WINS);
        List<Round> roundList = new ArrayList<>();
        roundList.add(round1);
        roundList.add(round2);
        roundList.add(round3);
        GameResult gameResult = new GameResult();
        gameResult.setGame(game);
        gameResult.setRoundList(roundList);
        jdbcRepository.createGameResult(id, gameResult);
        assertEquals(3, jdbcRepository.getGameResult(id).getRoundList().size());
    }
}
