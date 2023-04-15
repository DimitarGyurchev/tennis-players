package com.softuni.tennis_players.domain.dtos.binding;

import com.softuni.tennis_players.domain.enums.PlayerStyle;

public class TennisPlayerDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String imageUrl;
    private String nationality;
    private int age;
    private int ranking;
    private PlayerStyle playerStyle;

    public Long getId() {
        return id;
    }

    public TennisPlayerDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public TennisPlayerDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public TennisPlayerDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TennisPlayerDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public TennisPlayerDTO setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public int getAge() {
        return age;
    }

    public TennisPlayerDTO setAge(int age) {
        this.age = age;
        return this;
    }

    public int getRanking() {
        return ranking;
    }

    public TennisPlayerDTO setRanking(int ranking) {
        this.ranking = ranking;
        return this;
    }

    public PlayerStyle getPlayerStyle() {
        return playerStyle;
    }

    public TennisPlayerDTO setPlayerStyle(PlayerStyle playerStyle) {
        this.playerStyle = playerStyle;
        return this;
    }
}
