package com.softuni.tennis_players.services;


import com.softuni.tennis_players.domain.dtos.binding.AddTennisPlayerDTO;
import com.softuni.tennis_players.domain.dtos.view.TennisPlayerViewDTO;
import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import com.softuni.tennis_players.repositories.TennisPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TennisPlayerService {

    private final TennisPlayerRepository tennisPlayerRepository;

    @Autowired
    public TennisPlayerService(TennisPlayerRepository playerRepository) {
        this.tennisPlayerRepository = playerRepository;

    }

    public void addPlayer(AddTennisPlayerDTO addTennisPlayerDTO) {
        TennisPlayerEntity player = new TennisPlayerEntity()
                .setFirstName(addTennisPlayerDTO.getFirstName())
                .setLastName(addTennisPlayerDTO.getLastName())
                .setNationality(addTennisPlayerDTO.getNationality())
                .setSponsor(addTennisPlayerDTO.getSponsor())
                .setAge(addTennisPlayerDTO.getAge())
                .setCoach(addTennisPlayerDTO.getCoach())
                .setRanking(addTennisPlayerDTO.getRanking());
        this.tennisPlayerRepository.save(player);
    }
    public TennisPlayerViewDTO getPlayer(Long id){
        return tennisPlayerRepository.findById(id)
                .map(this::map)
                .orElseThrow(RuntimeException::new);

    }
    public List<TennisPlayerViewDTO> getAllPlayers(){
        return tennisPlayerRepository
                .findAll()
                .stream()
                .map(this::map)
                .toList();
    }

    private TennisPlayerViewDTO map(TennisPlayerEntity tennisPlayerEntity){
        return new TennisPlayerViewDTO()

                .setFirstName(tennisPlayerEntity.getFirstName())
                .setLastName(tennisPlayerEntity.getLastName())
                .setCoach(tennisPlayerEntity.getCoach().getName())
                .setSponsor(tennisPlayerEntity.getSponsor().getSponsorName().toString())
                .setNationality(tennisPlayerEntity.getNationality())
                .setRanking(tennisPlayerEntity.getRanking())
                .setAge(tennisPlayerEntity.getAge());
    }

    private TennisPlayerEntity getOnePlayer (long id){
        return tennisPlayerRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }

    public void deletePlayerById(long id) {
        tennisPlayerRepository.deleteById(id);
    }

}






