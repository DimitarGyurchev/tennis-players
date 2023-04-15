package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.dtos.binding.TennisPlayerDTO;
import com.softuni.tennis_players.domain.dtos.model.TennisPlayerModel;
import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import com.softuni.tennis_players.repositories.TennisPlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TennisPlayerService {

    private final TennisPlayerRepository tennisPlayerRepository;
    private final UserService userService;

    private final ModelMapper modelMapper;

    public TennisPlayerService(TennisPlayerRepository playerRepository, UserService userService, ModelMapper modelMapper) {
        this.tennisPlayerRepository = playerRepository;
        this.userService = userService;
        this.modelMapper = modelMapper;
    }


    public TennisPlayerDTO toDto(TennisPlayerEntity entity) {
        return modelMapper.map(entity, TennisPlayerDTO.class);
    }

    public List<TennisPlayerDTO> getAllPlayers() {
        List<TennisPlayerEntity> playerEntities = tennisPlayerRepository.findAll();
        return playerEntities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public Optional<TennisPlayerEntity> getPlayerById(Long id) {
        return tennisPlayerRepository.findById(id);
    }

    public TennisPlayerEntity createPlayer(TennisPlayerModel tennisPlayerModel) {
        TennisPlayerEntity tennisPlayerEntity = new TennisPlayerEntity();
        tennisPlayerEntity.setFirstName(tennisPlayerModel.getFirstName());
        tennisPlayerEntity.setLastName(tennisPlayerModel.getLastName());
        tennisPlayerEntity.setAge(tennisPlayerModel.getAge());
        tennisPlayerEntity.setImageUrl(tennisPlayerModel.getImageUrl());
        tennisPlayerEntity.setNationality(tennisPlayerModel.getNationality());
        tennisPlayerEntity.setPlayerStyle(tennisPlayerModel.getPlayerStyle());
        tennisPlayerEntity.setRanking(tennisPlayerModel.getRanking());

        return tennisPlayerRepository.save(tennisPlayerEntity);
    }








    public void deletePlayer(Long id) {
        tennisPlayerRepository.deleteById(id);
    }

    public void updatePlayer(Long id, TennisPlayerEntity player) {
        Optional<TennisPlayerEntity> existingPlayer = tennisPlayerRepository.findById(id);
        if (existingPlayer.isPresent()) {
            TennisPlayerEntity updatedPlayer = existingPlayer.get();
            updatedPlayer.setFirstName(player.getFirstName());
            updatedPlayer.setLastName(player.getLastName());
            updatedPlayer.setAge(player.getAge());
            updatedPlayer.setImageUrl(player.getImageUrl());
            updatedPlayer.setNationality(player.getNationality());
            updatedPlayer.setRanking(player.getRanking());
            tennisPlayerRepository.save(updatedPlayer);
        }
    }
}
