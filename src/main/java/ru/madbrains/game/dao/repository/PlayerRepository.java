package ru.madbrains.game.dao.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.madbrains.game.game.players.Player;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
