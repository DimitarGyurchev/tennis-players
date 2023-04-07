package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.dtos.binding.UserRegisterFormDto;
import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserRegisterFormDto registrationDTO) {

        UserEntity userEntity = new UserEntity().
                setFirstName(registrationDTO.getFirstName()).
                setLastName(registrationDTO.getLastName()).
                setEmail(registrationDTO.getEmail()).
                setPassword(passwordEncoder.encode(registrationDTO.getPassword()));

        userRepository.save(userEntity);
    }


    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = authentication.getName();
        return userRepository.findByUsername(currentUserName);
    }
}
