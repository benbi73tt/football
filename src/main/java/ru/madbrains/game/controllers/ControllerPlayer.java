package ru.madbrains.game.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.madbrains.game.game.players.Player;
import ru.madbrains.game.service.ServiceGame;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/game/table-football")
public class ControllerPlayer {

    @Autowired
    private ServiceGame serviceGame;

    @GetMapping("/player")
    public List<Player> game() {
        return serviceGame.getPlayer();
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
