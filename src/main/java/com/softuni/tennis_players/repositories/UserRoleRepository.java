package com.softuni.tennis_players.repositories;

import com.softuni.tennis_players.domain.enitities.UserRoleEntity;
import com.softuni.tennis_players.domain.enums.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity,Long> {
    Optional<UserRoleEntity> findByRole(UserRoleEnum role);
}
