package com.softuni.tennis_players.domain.enitities;

import com.softuni.tennis_players.domain.enums.PlayerStyle;
import jakarta.persistence.*;

@Entity
@Table(name="tennis_players")
public class TennisPlayerEntity extends  BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "player_style")
    private PlayerStyle playerStyle;

    @Column(name = "image_url")
    private String imageUrl;

    @Column
    private String nationality;

    @Column
    private int age;

    @Column
    private int ranking;

    public int getRanking() {
        return ranking;
    }

    public TennisPlayerEntity setRanking(int ranking) {
        this.ranking = ranking;
        return this;
    }

    public TennisPlayerEntity() {
    }

    public String getFirstName() {
        return firstName;
    }

    public TennisPlayerEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public TennisPlayerEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public PlayerStyle getPlayerStyle() {
        return playerStyle;
    }

    public TennisPlayerEntity setPlayerStyle(PlayerStyle playerStyle) {
        this.playerStyle = playerStyle;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public TennisPlayerEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public int getAge() {
        return age;
    }

    public TennisPlayerEntity setAge(int age) {
        this.age = age;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public TennisPlayerEntity setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }
}
