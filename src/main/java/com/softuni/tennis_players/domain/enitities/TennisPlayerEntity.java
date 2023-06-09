package com.softuni.tennis_players.domain.enitities;

import jakarta.persistence.*;

@Entity
@Table(name="tennis_players")
public class TennisPlayerEntity extends  BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;


    @Column
    private String nationality;

    @Column
    private int age;

    @Column
    private int ranking;

    @ManyToOne (fetch = FetchType.EAGER)
    private SponsorEntity sponsor;

    @ManyToOne (fetch = FetchType.EAGER)
    private CoachEntity coach;

    public TennisPlayerEntity() {
    }

    public SponsorEntity getSponsor() {
        return sponsor;
    }

    public TennisPlayerEntity setSponsor(SponsorEntity sponsor) {
        this.sponsor = sponsor;
        return this;
    }

    public CoachEntity getCoach() {
        return coach;
    }

    public TennisPlayerEntity setCoach(CoachEntity coach) {
        this.coach = coach;
        return this;
    }

    public int getRanking() {
        return ranking;
    }

    public TennisPlayerEntity setRanking(int ranking) {
        this.ranking = ranking;
        return this;
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
