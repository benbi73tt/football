package ru.madbrains.game.dto;

import lombok.Data;
import ru.madbrains.game.game.players.Player;

@Data
public class PlayerDTO {
    private String name;
    private Integer wins;
    private Integer numberOfGame;

    public static PlayerDTO from(Player player) {
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setNumberOfGame(player.getNumberOfGame());
        playerDTO.setWins(player.getWins());
        playerDTO.setName(player.getName());
        return playerDTO;
    }
}
