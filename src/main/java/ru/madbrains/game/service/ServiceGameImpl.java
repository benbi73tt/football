package ru.madbrains.game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.madbrains.game.game.Game;
import ru.madbrains.game.game.players.Player;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceGameImpl implements ServiceGame {

    @Autowired
    private Game game;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    @Transactional
    public void addPlayer(Player player) {

//        game.getPlayers().add(player);
        entityManager.persist(player);
    }

    @Override
    public List<Player> getPlayer() {
        List<Player> players = game.getPlayers().stream()
                .collect(Collectors.toList());
        return players;
    }

    @Override
    public Player infoPlayer(int id) {
//        Player player = game.getPlayers().get(id);
//        return player;
        Player player = entityManager.find(Player.class, id);
        entityManager.detach(player);
        return player;
    }

//    @Override
//    public void deletePlayer(int id) {
//
//    }
//
//    @Override
//    public void updatePlayer(int id) {
//
//    }
}
