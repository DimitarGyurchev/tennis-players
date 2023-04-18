package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    void testGetUsers() {
        List<UserEntity> userEntities = new ArrayList<>();
        userEntities.add(new UserEntity());
        when(userRepository.findAll()).thenReturn(userEntities);

        List<UserEntity> result = userService.getUsers();

        Assertions.assertEquals(userEntities.size(), result.size());
        Assertions.assertEquals(userEntities.get(0), result.get(0));
    }

    @Test
    void testGetUserById() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        when(userRepository.findUserEntityById(1L)).thenReturn(Optional.of(userEntity));

        UserEntity result = userService.getUserById(1L);

        Assertions.assertEquals(userEntity.getId(), result.getId());
    }
}
