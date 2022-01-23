package ru.madbrains.game.game.players;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @NotEmpty(message = "Name should not be empty")//нельзя пустое значение(Ошибка)
    @Size(min = 2, max = 12, message = "Name should be between 2 and 12 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    @NotEmpty(message = "Name should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Column(name="numberOfGame")
    private Integer numberOfGame;

    @Column(name="wins")
    private Integer wins;





}
