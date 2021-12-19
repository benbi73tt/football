package ru.madbrains.game.game.players;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
public class Player {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Name should not be empty")//нельзя пустое значение(Ошибка)
    @Size(min = 2, max = 12, message = "Name should be between 2 and 12 characters")
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    @NotEmpty(message = "Name should not be empty")
    @Email(message = "Email should be valid")
    private String email;

    public Player(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





}
