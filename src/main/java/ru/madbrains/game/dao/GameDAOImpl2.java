package ru.madbrains.game.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import ru.madbrains.game.dao.repository.PlayerRepository;
import ru.madbrains.game.game.players.Player;

@Slf4j
@Primary
@Component
public class GameDAOImpl2 implements GameDAO{

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void addPlayer(Player player) {
        checked(player);
        playerRepository.save(player);
    }

    @Override
    public Player infoPlayer(int id) {
        return playerRepository.findById(id).orElse(null);
    }

    @Override
    public void deletePlayer(int id) {
        playerRepository.deleteById(id);
    }

    @Override
    public void updatePlayer(int id, Player player) {
        checked(player);
        player.setId(id);
        playerRepository.save(player);
    }

    public Player checked(Player player){
        if (player.getNumberOfGame() == null) {
            player.setWins(0);
            player.setNumberOfGame(0);
        } else if (player.getWins() == null) {
            player.setWins(0);
        }
        return player;
    }
}
