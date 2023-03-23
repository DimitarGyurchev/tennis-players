package com.softuni.tennis_players.domain.enitities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tennis_coaches")
public class TennisCoachEntity extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column
    private String nationality;

    @Column
    private int age;

    public String getFirstName() {
        return firstName;
    }

    public TennisCoachEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public TennisCoachEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public TennisCoachEntity setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public int getAge() {
        return age;
    }

    public TennisCoachEntity setAge(int age) {
        this.age = age;
        return this;
    }
}
