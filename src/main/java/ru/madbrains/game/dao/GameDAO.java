package ru.madbrains.game.dao;

import ru.madbrains.game.game.players.Player;

import java.util.List;

public interface GameDAO {
    void addPlayer(Player player);
//    List<Player> getPlayer();
    Player infoPlayer(int id);
    void deletePlayer(int id);
    void updatePlayer(int id, Player player);
}
