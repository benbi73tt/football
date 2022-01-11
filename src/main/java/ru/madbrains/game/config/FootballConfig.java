package ru.madbrains.game.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import ru.madbrains.game.game.Game;

@Configuration
@ComponentScan("ru.madbrains.game.game")
public class FootballConfig {

    @Bean("GameName")
    @Primary
    public String getGameName(){
        return "Football";
    }

//    @Bean("MaxPlayerCount")
//    public int getPlayerCount(){
//        return 20;
//    }

}
