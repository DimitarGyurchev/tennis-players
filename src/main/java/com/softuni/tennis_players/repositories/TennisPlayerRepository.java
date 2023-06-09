package com.softuni.tennis_players.repositories;

import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import com.softuni.tennis_players.domain.enitities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TennisPlayerRepository extends JpaRepository<TennisPlayerEntity,Long> {
    Optional<TennisPlayerEntity> findById(Long id);
}
