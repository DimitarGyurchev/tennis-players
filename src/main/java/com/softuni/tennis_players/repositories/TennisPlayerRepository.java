package com.softuni.tennis_players.repositories;

import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import com.softuni.tennis_players.domain.enitities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TennisPlayerRepository extends JpaRepository<TennisPlayerEntity,Long> {
List<TennisPlayerEntity> findAllByCreatedBy(UserEntity user);

}
