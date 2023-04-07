package com.softuni.tennis_players.domain.enitities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="sponsors")
public class SponsorEntity extends BaseEntity {

    @Column(unique = true,nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public SponsorEntity setName(String name) {
        this.name = name;
        return this;
    }
}
