package ru.madbrains.game.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import ru.madbrains.game.dao.GameDAO;
import ru.madbrains.game.game.Game;
import ru.madbrains.game.game.players.Player;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ServiceGameImpl implements ServiceGame {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    private Game game;

    @Autowired
    GameDAO gameDAO;

    public ServiceGameImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    @Transactional
    public void addPlayer(Player player) {

//        game.getPlayers().add(player);
        gameDAO.addPlayer(player);
    }

//    @Override
//    public List<Player> getPlayer() {
//        return gameDAO.getPlayer();
//    }

    @Override
//    @Transactional
    public Player infoPlayer(int id) {
//        Player player = game.getPlayers().get(id);
//        return player;
        return gameDAO.infoPlayer(id);
    }

    @Override
    @Transactional
    public void deletePlayer(int id) {
        gameDAO.deletePlayer(id);
    }

    @Override
    @Transactional
    public void updatePlayer(int id, Player player) {
        gameDAO.updatePlayer(id, player);
    }
}
