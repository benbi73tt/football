package ru.madbrains.game.dto;

import lombok.Data;
import ru.madbrains.game.game.Game;
import ru.madbrains.game.game.players.Player;

import java.util.List;

@Data
public class GameDTO {
    private String name;
    private List<Player> players;

public static GameDTO from(Game game){
    GameDTO gameDTO = new GameDTO();
    gameDTO.setName(game.getName());
    gameDTO.setPlayers(game.getPlayers());
    return gameDTO;
}
}
