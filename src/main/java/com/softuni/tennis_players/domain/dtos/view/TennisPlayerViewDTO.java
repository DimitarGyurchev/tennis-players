package com.softuni.tennis_players.domain.dtos.view;

import com.softuni.tennis_players.domain.enitities.CoachEntity;
import com.softuni.tennis_players.domain.enitities.SponsorEntity;

public class TennisPlayerViewDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String sponsor;
    private String nationality;
    private int age;
    private int ranking;
    private String coach;

    public String getSponsor() {
        return sponsor;
    }

    public TennisPlayerViewDTO setSponsor(String sponsor) {
        this.sponsor = sponsor;
        return this;
    }

    public String getCoach() {
        return coach;
    }

    public TennisPlayerViewDTO setCoach(String coach) {
        this.coach = coach;
        return this;
    }

    public TennisPlayerViewDTO() {

    }



    public Long getId() {
        return id;
    }

    public TennisPlayerViewDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public TennisPlayerViewDTO setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public TennisPlayerViewDTO setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }



    public String getNationality() {
        return nationality;
    }

    public TennisPlayerViewDTO setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public int getAge() {
        return age;
    }

    public TennisPlayerViewDTO setAge(int age) {
        this.age = age;
        return this;
    }

    public int getRanking() {
        return ranking;
    }

    public TennisPlayerViewDTO setRanking(int ranking) {
        this.ranking = ranking;
        return this;
    }




}
