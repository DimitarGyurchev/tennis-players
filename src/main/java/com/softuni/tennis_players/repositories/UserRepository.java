package com.softuni.tennis_players.repositories;

import com.softuni.tennis_players.domain.enitities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
