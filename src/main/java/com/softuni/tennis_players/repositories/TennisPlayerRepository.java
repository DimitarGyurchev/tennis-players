package com.softuni.tennis_players.repositories;

import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import com.softuni.tennis_players.domain.enums.PlayerStyle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TennisPlayerRepository extends JpaRepository<TennisPlayerEntity,Long> {
    List<TennisPlayerEntity> findByNationality(String nationality);
    List<TennisPlayerEntity> findByPlayerStyle(PlayerStyle playerStyle);
    List<TennisPlayerEntity> findByAgeGreaterThanEqual(int age);
    List<TennisPlayerEntity> findByAgeLessThanEqual(int age);
    List<TennisPlayerEntity> findByRankingGreaterThanEqual(int ranking);
    List<TennisPlayerEntity> findByRankingLessThanEqual(int ranking);
    List<TennisPlayerEntity> findAllByCreatedBy(String user);

}
