package ru.madbrains.game.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.madbrains.game.dto.GameDTO;
import ru.madbrains.game.game.players.Player;
import ru.madbrains.game.service.ServiceGame;

@Slf4j
@RestController
@RequestMapping("/game/table-football")
public class ControllerPlayer {

    @Autowired
    private ServiceGame serviceGame;

    @GetMapping("/player")
    public GameDTO game() {
        return GameDTO.from(serviceGame.getGame());
    }

    @PostMapping("/player")
    public ResponseEntity addPlayer(@RequestBody Player player) {
        log.info("add player");
        serviceGame.addPlayer(player);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/player/{id}")
    public ResponseEntity getPlayerByIndex(@PathVariable int index) {
        log.info("get player by index " + index);
        return ResponseEntity.ok(serviceGame.infoPlayer(index));
    }


}
