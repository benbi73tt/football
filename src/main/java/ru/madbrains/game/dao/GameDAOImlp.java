package ru.madbrains.game.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import ru.madbrains.game.game.Game;
import ru.madbrains.game.game.players.Player;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

//@Primary
@Repository
public class GameDAOImlp implements GameDAO {


    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private Game game;


    @Override
    public void addPlayer(Player player) {
        checked(player);
        entityManager.persist(player);
    }

//    @Override
//    public List<Player> getPlayer() {
//        List<Player> players = game.getPlayers().stream()
//                .collect(Collectors.toList());
//        return players;
//    }

    @Override
    public Player infoPlayer(int id) {
        Player player = entityManager.find(Player.class, id);
        entityManager.detach(player);
        return player;
    }

    @Override
    public void deletePlayer(int id) {
        Player player = infoPlayer(id);
        entityManager.remove(player);
    }

    @Override
    public void updatePlayer(int id, Player player) {
        checked(player);
        player.setId(id);
        entityManager.merge(player);
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
