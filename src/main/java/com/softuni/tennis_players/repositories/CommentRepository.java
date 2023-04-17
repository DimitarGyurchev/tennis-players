package com.softuni.tennis_players.repositories;

import com.softuni.tennis_players.domain.enitities.CommentEntity;
import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    Optional<List<CommentEntity>> findAllByTennisPlayer(TennisPlayerEntity tennisPlayer);
}