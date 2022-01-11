package ru.madbrains.game.service;

import ru.madbrains.game.game.Game;
import ru.madbrains.game.game.players.Player;

import java.util.List;

public interface ServiceGame {
    Game getGame();
    void addPlayer(Player player);
    List<Player> getPlayer();
    Player infoPlayer(int id);
    void deletePlayer(int id);
    void updatePlayer(int id, Player player);

}
