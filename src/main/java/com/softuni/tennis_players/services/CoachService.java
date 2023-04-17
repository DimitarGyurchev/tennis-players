package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.dtos.binding.AddCoachDTO;
import com.softuni.tennis_players.domain.enitities.CoachEntity;
import com.softuni.tennis_players.repositories.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {
    private final CoachRepository coachRepository;

    @Autowired
    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }

    public List<CoachEntity> getAllCoaches(){
        return coachRepository.findAll();
    }

    public void addCoach(AddCoachDTO addCoachDTO){
        CoachEntity coach = new CoachEntity()
                .setName(addCoachDTO.getName())
                .setYearOfBirth(addCoachDTO.getYearOfBirth())
                .setNationality(addCoachDTO.getNationality());
        this.coachRepository.save(coach);
    }

    public List<AddCoachDTO> getCoaches(){
        return coachRepository
                .findAll()
                .stream()
                .map(this::map)
                .toList();
    }
    private AddCoachDTO map (CoachEntity coachEntity){
        return new AddCoachDTO()
                .setName(coachEntity.getName())
                .setYearOfBirth(coachEntity.getYearOfBirth())
                .setNationality(coachEntity.getNationality());
    }
}
