package com.softuni.tennis_players.domain.dtos.model;

import com.softuni.tennis_players.domain.enums.PlayerStyle;

public class TennisPlayerModel {

    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    private String imageUrl;

    private String nationality;

    private int ranking;

    private PlayerStyle playerStyle;

    public Long getId() {
        return id;
    }

    public TennisPlayerModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public TennisPlayerModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public TennisPlayerModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public int getAge() {
        return age;
    }

    public TennisPlayerModel setAge(int age) {
        this.age = age;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TennisPlayerModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public TennisPlayerModel setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public int getRanking() {
        return ranking;
    }

    public TennisPlayerModel setRanking(int ranking) {
        this.ranking = ranking;
        return this;
    }

    public PlayerStyle getPlayerStyle() {
        return playerStyle;
    }

    public TennisPlayerModel setPlayerStyle(PlayerStyle playerStyle) {
        this.playerStyle = playerStyle;
        return this;
    }
}
