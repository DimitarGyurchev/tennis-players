package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.domain.enitities.UserRoleEntity;
import com.softuni.tennis_players.domain.enums.UserRoleEnum;
import com.softuni.tennis_players.repositories.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class InitService {
    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final CoachRepository coachRepository;
    private final SponsorRepository sponsorRepository;
    private final TennisPlayerRepository tennisPlayerRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public InitService(UserRoleRepository userRoleRepository, UserRepository userRepository, CoachRepository coachRepository, SponsorRepository sponsorRepository, TennisPlayerRepository tennisPlayerRepository, PasswordEncoder passwordEncoder) {
        this.userRoleRepository = userRoleRepository;
        this.userRepository = userRepository;
        this.coachRepository = coachRepository;
        this.sponsorRepository = sponsorRepository;
        this.tennisPlayerRepository = tennisPlayerRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostConstruct
    public void init(){
        initRoles();
        initUsers();
    }
    private void initRoles() {
        if (userRoleRepository.count() == 0) {
            var admin = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
            var user = new UserRoleEntity().setRole(UserRoleEnum.USER);
            userRoleRepository.save(admin);
            userRoleRepository.save(user);
        }
    }
    private void initUsers() {
        if (userRepository.count() == 0) {
            initAdmin();
            initUser();
        }
    }

    private void initAdmin() {
        var admin = new UserEntity()
                .setUsername("dimi")
                .setPassword(passwordEncoder.encode("asdasd"))
                .setEmail("dimi@abv.com")
                .setFullName("Dimi Dimov")
                .setRoles(userRoleRepository.findAll());
        userRepository.save(admin);
    }
    private void initUser() {
        var user = new UserEntity()
                .setUsername("mimi")
                .setPassword(passwordEncoder.encode("asdasd"))
                .setEmail("mimi@abv.com")
                .setFullName("Mimi Mimova")
                .setRoles(userRoleRepository.findUserRoleByRole(UserRoleEnum.USER));
        userRepository.save(user);
    }

}
