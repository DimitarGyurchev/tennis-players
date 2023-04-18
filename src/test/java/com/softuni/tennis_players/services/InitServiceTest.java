package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.domain.enitities.UserRoleEntity;
import com.softuni.tennis_players.domain.enums.UserRoleEnum;
import com.softuni.tennis_players.repositories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InitServiceTest {
    @Mock
    private UserRoleRepository userRoleRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private CoachRepository coachRepository;
    @Mock
    private SponsorRepository sponsorRepository;
    @Mock
    private TennisPlayerRepository tennisPlayerRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private InitService initService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testInitRoles_whenNoRolesInDatabase_shouldSaveRoles() {
        when(userRoleRepository.count()).thenReturn(0L);

        initService.initRoles();

        verify(userRoleRepository, times(1)).count();

        ArgumentCaptor<UserRoleEntity> roleCaptor = ArgumentCaptor.forClass(UserRoleEntity.class);
        verify(userRoleRepository, times(2)).save(roleCaptor.capture());

        List<UserRoleEntity> savedRoles = roleCaptor.getAllValues();
        assertEquals(UserRoleEnum.ADMIN, savedRoles.get(0).getRole());
        assertEquals(UserRoleEnum.USER, savedRoles.get(1).getRole());
    }



    @Test
    public void testInitAdmin_shouldSaveAdminUser() {
        List<UserRoleEntity> roles = new ArrayList<>();
        roles.add(new UserRoleEntity().setRole(UserRoleEnum.ADMIN));
        when(userRoleRepository.findAll()).thenReturn(roles);

        initService.initAdmin();

        ArgumentCaptor<UserEntity> userCaptor = ArgumentCaptor.forClass(UserEntity.class);
        verify(userRepository, times(1)).save(userCaptor.capture());

        UserEntity savedUser = userCaptor.getValue();
        assertEquals("dimi", savedUser.getUsername());
        assertEquals("dimi@abv.com", savedUser.getEmail());
        assertEquals("Dimi Dimov", savedUser.getFullName());
        assertFalse(passwordEncoder.matches("asdasd", savedUser.getPassword()));
        assertEquals(1, savedUser.getRoles().size());
        assertEquals(UserRoleEnum.ADMIN, savedUser.getRoles().get(0).getRole());
    }
    @Test
    void testInit() {
        when(userRoleRepository.count()).thenReturn(0L);
        when(userRepository.count()).thenReturn(0L);
        when(userRoleRepository.findAll()).thenReturn(Arrays.asList(new UserRoleEntity().setRole(UserRoleEnum.ADMIN), new UserRoleEntity().setRole(UserRoleEnum.USER)));
        when(userRoleRepository.findUserRoleByRole(UserRoleEnum.USER)).thenReturn(Arrays.asList(new UserRoleEntity().setRole(UserRoleEnum.USER)));

        initService.init();

        verify(userRoleRepository, times(1)).count();
        verify(userRepository, times(1)).count();
        verify(userRoleRepository, times(1)).findAll();
        verify(userRoleRepository, times(1)).findUserRoleByRole(UserRoleEnum.USER);
        verify(userRoleRepository, times(2)).save(any(UserRoleEntity.class));
        verify(userRepository, times(2)).save(any(UserEntity.class));
    }


}
