package ru.madbrains.game.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.madbrains.game.game.players.Player;

import java.util.ArrayList;
import java.util.List;


@Component("GameComponent")
public class Game {
    private List<Player> players;

    @Value("Football")
    private String name;

    public Game(@Qualifier("GameName") String gameName){
        this.name = gameName;
        this.players = new ArrayList<>();

    }

    @Override
    public String toString() {
        return "Game {" +
                "name = '" + name + '\'' +
                '}';
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
