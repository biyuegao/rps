package com.xp.rps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class RPSController {
    @Autowired
    RPSRepository repository;
    @Autowired
    RPS rps;

    @PostMapping("/game")
    int createGame(@RequestBody Game game) {
        int id = repository.createGame(game);
        return id;
    }

    @GetMapping("/game/{id}")
    Game getGame(@PathVariable int id) {
        return repository.getGame(id);
    }

    @PostMapping("/play/{id}")
    Round play(@PathVariable int id, @RequestBody Round request) {
        Result result = rps.play(request.getThrow1(), request.getThrow2());
        Round round = new Round(request.getThrow1(), request.getThrow2(), result);
        GameResult gameResult = repository.getGameResult(id);
        if(gameResult != null) {
            List<Round> roundList = gameResult.getRoundList();
            roundList.add(round);
            gameResult.setRoundList(roundList);
            repository.createGameResult(id, gameResult);
        }
        return round;
    }
    @GetMapping("/gameresult/{id}")
    GameResult getGameResult(@PathVariable int id) {
        GameResult gameResult = repository.getGameResult(id);
        return gameResult;
    }
}
