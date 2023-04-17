package com.softuni.tennis_players.repositories;

import com.softuni.tennis_players.domain.enitities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    Optional<UserEntity> findUserEntityByUsername (String username);
    Optional<UserEntity> findByEmail (String email);
    Optional<UserEntity> findUserEntityById (Long id);
}
