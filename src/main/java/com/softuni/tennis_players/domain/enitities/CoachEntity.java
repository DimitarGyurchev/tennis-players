package com.softuni.tennis_players.domain.enitities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="coaches")
public class CoachEntity extends BaseEntity {
    @Column(nullable = false)
    private String name;
    @Column
    private long yearOfBirth;
    @Column(nullable = false)
    private String nationality;

    public CoachEntity() {
    }

    public CoachEntity(String name, long yearOfBirth, String nationality) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public CoachEntity setName(String name) {
        this.name = name;
        return this;
    }

    public long getYearOfBirth() {
        return yearOfBirth;
    }

    public CoachEntity setYearOfBirth(long yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public CoachEntity setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }
}
