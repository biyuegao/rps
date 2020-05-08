package com.xp.rps;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class JDBCRepository implements RPSRepository{
    final JdbcTemplate jdbcTemplate;

    private String CREATE_GAME_SQL = "insert into game (player1, player2, round) values (?, ?, ?)";
    private String GET_GAME_SQL = "select * from game where id = ?";
    private String GET_ROUND_SQL = "select * from round where game_id = ?";
    private String CREATE_ROUND_SQL = "insert into round (game_id, throw1, throw2, result) values (?, ?, ?, ?)";

    public JDBCRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createGame(Game game) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(CREATE_GAME_SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, game.getPlayer1());
            ps.setString(2, game.getPlayer2());
            ps.setInt(3, game.getRound());
            return ps;
        }, keyHolder);
        return (int)keyHolder.getKeys().get("id");
    }

    @Override
    public Game getGame(int id) {
        Game game = jdbcTemplate.queryForObject(GET_GAME_SQL, new Object[]{id}, (rs, rowNum) ->
        new Game(
                rs.getInt("id"),
                rs.getString("player1"),
                rs.getString("player2"),
                rs.getInt("round")
        ));
        return game;
    }

    @Override
    public void createGameResult(int id, GameResult gameResult) {
        List<Round> roundList = gameResult.getRoundList();
        for(Round round : roundList) {
            if(round.getRoundId() == 0) {
                jdbcTemplate.update(CREATE_ROUND_SQL,
                        id,
                        round.getThrow1().toString(),
                        round.getThrow2().toString(),
                        round.getResult().toString());
            }
        }
    }

    @Override
    public GameResult getGameResult(int id) {
        List<Round> roundList = jdbcTemplate.query(GET_ROUND_SQL, new Object[]{id}, mapper);
        return new GameResult(this.getGame(id), roundList);
    }

    private final RowMapper<Round> mapper = (rs, rowNum) -> new Round(
            rs.getInt("id"),
            Throw.valueOf(rs.getString("throw1")),
            Throw.valueOf(rs.getString("throw2")),
            Result.valueOf(rs.getString("result"))
    );
}
