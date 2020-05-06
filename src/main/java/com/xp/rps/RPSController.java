package com.xp.rps;

import org.springframework.web.bind.annotation.*;

@RestController
public class RPSController {
//    @Autowired
    final RPSRepository repository;

    public RPSController(RPSRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/game")
    int createGame(@RequestBody Game game) {
        int id = repository.createGame(game);
        return id;
    }

    @GetMapping("/game/{id}")
    Game getGame(@PathVariable int id) {
        return repository.getGame(id);
    }
}
