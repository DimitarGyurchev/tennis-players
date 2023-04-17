package com.softuni.tennis_players.repositories;

import com.softuni.tennis_players.domain.enitities.CoachEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoachRepository extends JpaRepository<CoachEntity,Long> {

    Optional<CoachEntity> findCoachByName(String coachName);
    List<CoachEntity> findAll();
}
