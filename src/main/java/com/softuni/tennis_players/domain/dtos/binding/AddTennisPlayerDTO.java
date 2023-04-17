package com.softuni.tennis_players.domain.dtos.binding;

import com.softuni.tennis_players.domain.enums.PlayerStyle;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AddTennisPlayerDTO {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String imageUrl;
    @NotNull
    private String nationality;
    @NotNull
    @Positive
    private int age;
    @NotNull
    @Positive
    private int ranking;
    @NotNull
    private PlayerStyle playerStyle;

    public AddTennisPlayerDTO( String firstName, String lastName, String imageUrl, String nationality, int age, int ranking, PlayerStyle playerStyle) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageUrl = imageUrl;
        this.nationality = nationality;
        this.age = age;
        this.ranking = ranking;
        this.playerStyle = playerStyle;
    }



    public String getFirstName() {
        return firstName;
    }

    public AddTennisPlayerDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public AddTennisPlayerDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public AddTennisPlayerDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public AddTennisPlayerDTO setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public int getAge() {
        return age;
    }

    public AddTennisPlayerDTO setAge(int age) {
        this.age = age;
        return this;
    }

    public int getRanking() {
        return ranking;
    }

    public AddTennisPlayerDTO setRanking(int ranking) {
        this.ranking = ranking;
        return this;
    }

    public PlayerStyle getPlayerStyle() {
        return playerStyle;
    }

    public AddTennisPlayerDTO setPlayerStyle(PlayerStyle playerStyle) {
        this.playerStyle = playerStyle;
        return this;
    }
}
