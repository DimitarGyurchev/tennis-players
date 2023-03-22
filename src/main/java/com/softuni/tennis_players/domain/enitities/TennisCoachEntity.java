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

}
