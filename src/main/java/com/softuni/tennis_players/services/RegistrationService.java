package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.dtos.binding.RegistrationDTO;
import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.domain.enums.UserRoleEnum;
import com.softuni.tennis_players.repositories.UserRepository;
import com.softuni.tennis_players.repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public RegistrationService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRoleRepository = userRoleRepository;
    }

    public void register(RegistrationDTO registrationDTO) {
        if (!registrationDTO.getPassword().equals(registrationDTO.getConfirmPassword())) {
            throw new RuntimeException("passwords don't match");
        }
        Optional<UserEntity> byEmail = this.userRepository.findByEmail(registrationDTO.getEmail());
        if (byEmail.isPresent()) {
            throw new RuntimeException("email.used");
        }
        Optional<UserEntity> byUsername = this.userRepository.findUserEntityByUsername(registrationDTO.getUsername());
        if (byUsername.isPresent()) {
            throw new RuntimeException("username.used");
        }
        UserEntity user = new UserEntity().
                setUsername(registrationDTO.getUsername()).
                setEmail(registrationDTO.getEmail()).
                setPassword(passwordEncoder.encode(registrationDTO.getPassword())).
                setFullName(registrationDTO.getFullName()).
                setRoles(userRoleRepository.findUserRoleByRole(UserRoleEnum.USER));
        this.userRepository.save(user);
    }

    public UserEntity getUser(String username) {
        return userRepository.findUserEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username + " was not found!"));
    }
}
