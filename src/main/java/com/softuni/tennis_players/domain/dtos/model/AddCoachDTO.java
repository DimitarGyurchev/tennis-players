package com.softuni.tennis_players.domain.dtos.model;

import jakarta.validation.constraints.NotNull;

public class AddCoachDTO {
    @NotNull
    private String name;
    @NotNull
    private long yearOfBirth;
    @NotNull
    private String nationality;

    public AddCoachDTO() {
    }

    public String getName() {
        return name;
    }

    public AddCoachDTO setName(String name) {
        this.name = name;
        return this;
    }

    public long getYearOfBirth() {
        return yearOfBirth;
    }

    public AddCoachDTO setYearOfBirth(long yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public AddCoachDTO setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }
}
