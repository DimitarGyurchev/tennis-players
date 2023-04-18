package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.domain.enitities.UserRoleEntity;
import com.softuni.tennis_players.domain.enums.UserRoleEnum;
import com.softuni.tennis_players.repositories.UserRepository;
import com.softuni.tennis_players.services.ApplicationUserDetailsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ApplicationUserDetailsServiceTest {
    private ApplicationUserDetailsService toTest;
    @Mock
    private UserRepository mockUserRepository;
    @BeforeEach
    void setUp() {
        toTest = new ApplicationUserDetailsService(
                mockUserRepository
        );
    }
    @Test
    void testUserNotFound() {
        Assertions.assertThrows(
                UsernameNotFoundException.class,
                () -> toTest.loadUserByUsername("not_existing_username")
        );
    }
    @Test
    void testUserFound() {
        UserRoleEntity testAdminRole = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
        UserRoleEntity testUserRole = new UserRoleEntity().setRole(UserRoleEnum.USER);
        UserEntity testUserEntity = new UserEntity()
                .setUsername("test")
                .setPassword("test12345")
                .setRoles(List.of(testAdminRole, testUserRole));
        when(mockUserRepository.findUserEntityByUsername("test")).
                thenReturn(Optional.of(testUserEntity));
        UserDetails adminDetails =
                toTest.loadUserByUsername("test");
        Assertions.assertNotNull(adminDetails);
        Assertions.assertEquals("test", adminDetails.getUsername());
        Assertions.assertEquals(testUserEntity.getPassword(), adminDetails.getPassword());
        Assertions.assertEquals(2,
                adminDetails.getAuthorities().size());
    }
}