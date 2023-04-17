package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.enitities.SponsorEntity;
import com.softuni.tennis_players.repositories.SponsorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorService {
    private final SponsorRepository sponsorRepository;


    public SponsorService(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    public List<SponsorEntity> getAllSponsors (){
        return sponsorRepository.findAll();
    }
}
