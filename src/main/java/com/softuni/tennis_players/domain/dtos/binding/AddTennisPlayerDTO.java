package com.softuni.tennis_players.domain.dtos.binding;

import com.softuni.tennis_players.domain.enitities.CoachEntity;
import com.softuni.tennis_players.domain.enitities.SponsorEntity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class AddTennisPlayerDTO {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @NotNull
    private String nationality;
    @NotNull
    @Positive
    private int age;
    @NotNull
    @Positive
    private int ranking;
    @NotNull
    private CoachEntity coach;

    @NotNull
    private SponsorEntity sponsor;

    public CoachEntity getCoach() {
        return coach;
    }

    public AddTennisPlayerDTO setCoach(CoachEntity coach) {
        this.coach = coach;
        return this;
    }

    public SponsorEntity getSponsor() {
        return sponsor;
    }

    public AddTennisPlayerDTO setSponsor(SponsorEntity sponsor) {
        this.sponsor = sponsor;
        return this;
    }

    public AddTennisPlayerDTO(String firstName, String lastName, String nationality, int age, int ranking, CoachEntity coach, SponsorEntity sponsor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationality = nationality;
        this.age = age;
        this.ranking = ranking;
        this.coach = coach;
        this.sponsor = sponsor;
    }

    public AddTennisPlayerDTO() {

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



}
