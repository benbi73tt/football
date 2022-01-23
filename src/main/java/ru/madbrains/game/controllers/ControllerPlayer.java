package ru.madbrains.game.controllers;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.madbrains.game.dto.GameDTO;
import ru.madbrains.game.dto.PlayerDTO;
import ru.madbrains.game.game.players.Player;
import ru.madbrains.game.service.ServiceGame;

import javax.persistence.PostUpdate;
import javax.persistence.PreUpdate;

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

    @GetMapping("/player/{index}")
    public ResponseEntity getPlayerByIndex(@PathVariable int index) {
        log.info("get player by index " + index);
        try{
            PlayerDTO dto = PlayerDTO.from(serviceGame.infoPlayer(index));
            return ResponseEntity.ok(dto);
        } catch (IndexOutOfBoundsException e){
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/player/{index}")
    public ResponseEntity deletePlayerByIndex(@PathVariable int index) {
        log.info("delete player by index " + index);
        serviceGame.deletePlayer(index);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/player/{index}")
    public ResponseEntity updatePlayerByIndex(@PathVariable int index,
                                              @RequestBody Player player) {
        log.info("update player by index " + index);
        serviceGame.updatePlayer(index,player);
        return ResponseEntity.ok().build();
    }


}
