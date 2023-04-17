package com.softuni.tennis_players.domain.enitities;

import com.softuni.tennis_players.domain.enums.SponsorEnum;
import jakarta.persistence.*;

@Entity
@Table(name="sponsors")
public class SponsorEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "sponsor_name")
    private SponsorEnum sponsorName;

    public SponsorEntity() {
    }

    public SponsorEnum getSponsorName() {
        return sponsorName;
    }

    public SponsorEntity setSponsorName(SponsorEnum sponsorName) {
        this.sponsorName = sponsorName;
        return this;
    }
}
