package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.dtos.binding.RegistrationDTO;
import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.domain.enums.UserRoleEnum;
import com.softuni.tennis_players.repositories.UserRepository;
import com.softuni.tennis_players.repositories.UserRoleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class RegistrationServiceTest {

    private RegistrationService registrationService;
    @Mock
    private UserRepository userRepository;
    @Mock
   private UserService userService;;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private UserRoleRepository userRoleRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        registrationService = new RegistrationService(userRepository, passwordEncoder, userRoleRepository);
        userService = new UserService(userRepository);
    }

    @Test
    void testRegister() {
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setUsername("testUsername");
        registrationDTO.setEmail("test@test.com");
        registrationDTO.setPassword("testPassword");
        registrationDTO.setConfirmPassword("testPassword");
        registrationDTO.setFullName("testFullName");
        UserEntity userEntity = new UserEntity();
        when(userRepository.findByEmail(registrationDTO.getEmail())).thenReturn(Optional.empty());
        when(userRepository.findUserEntityByUsername(registrationDTO.getUsername())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(registrationDTO.getPassword())).thenReturn("encodedPassword");
        when(userRoleRepository.findUserRoleByRole(UserRoleEnum.USER)).thenReturn(null);
        when(userRepository.save(userEntity)).thenReturn(userEntity);

        registrationService.register(registrationDTO);

        Assertions.assertNotEquals(registrationDTO.getUsername(), userEntity.getUsername());
        Assertions.assertNotEquals(registrationDTO.getEmail(), userEntity.getEmail());
        Assertions.assertNotEquals("encodedPassword", userEntity.getPassword());
        Assertions.assertNotEquals(registrationDTO.getFullName(), userEntity.getFullName());
    }

    @Test
    void testRegisterWithMismatchedPasswords() {
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setUsername("testUsername");
        registrationDTO.setEmail("test@test.com");
        registrationDTO.setPassword("testPassword");
        registrationDTO.setConfirmPassword("differentPassword");
        registrationDTO.setFullName("testFullName");

        Assertions.assertThrows(RuntimeException.class, () -> registrationService.register(registrationDTO), "passwords don't match");
    }

    @Test
    void testRegisterWithExistingEmail() {
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setUsername("testUsername");
        registrationDTO.setEmail("test@test.com");
        registrationDTO.setPassword("testPassword");
        registrationDTO.setConfirmPassword("testPassword");
        registrationDTO.setFullName("testFullName");
        when(userRepository.findByEmail(registrationDTO.getEmail())).thenReturn(Optional.of(new UserEntity()));

        Assertions.assertThrows(RuntimeException.class, () -> registrationService.register(registrationDTO), "email.used");
    }

    @Test
    void testRegisterWithExistingUsername() {
        RegistrationDTO registrationDTO = new RegistrationDTO();
        registrationDTO.setUsername("testUsername");
        registrationDTO.setEmail("test@test.com");
        registrationDTO.setPassword("testPassword");
        registrationDTO.setConfirmPassword("testPassword");
        registrationDTO.setFullName("testFullName");
        when(userRepository.findUserEntityByUsername(registrationDTO.getUsername())).thenReturn(Optional.of(new UserEntity()));

        Assertions.assertThrows(RuntimeException.class, () -> registrationService.register(registrationDTO), "username.used");
    }
    @Test
    void testGetUserByUsername() {
        String username = "testUsername";
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(username);
        when(userRepository.findUserEntityByUsername(username)).thenReturn(Optional.of(userEntity));

        UserEntity result = userService.getUser(username);

        Assertions.assertEquals(userEntity, result);
    }

    @Test
    void testGetUserByUsernameWithNonExistingUsername() {
        String username = "testUsername";
        when(userRepository.findUserEntityByUsername(username)).thenReturn(Optional.empty());

        Assertions.assertThrows(UsernameNotFoundException.class, () -> userService.getUser(username), username + " was not found!");
    }
}
