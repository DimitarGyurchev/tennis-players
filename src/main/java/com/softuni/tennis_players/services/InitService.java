package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.enitities.*;
import com.softuni.tennis_players.domain.enums.SponsorEnum;
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
        initContent();
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
    private void initContent(){
        var adidas = new SponsorEntity()
                .setSponsorName(SponsorEnum.ADIDAS);
        var nike = new SponsorEntity()
                .setSponsorName(SponsorEnum.NIKE);
        var lacoste = new SponsorEntity()
                .setSponsorName(SponsorEnum.LACOSTE);
        var lotto = new SponsorEntity()
                .setSponsorName(SponsorEnum.LOTTO);
        var armani = new SponsorEntity()
                .setSponsorName(SponsorEnum.ARMANI);

        if(sponsorRepository.count()==0){
            sponsorRepository.save(adidas);
            sponsorRepository.save(nike);
            sponsorRepository.save(lacoste);
            sponsorRepository.save(lotto);
            sponsorRepository.save(armani);
        }
        if(tennisPlayerRepository.count()==0){
            var coach = new CoachEntity()
                    .setName("Ivan Lubicic")
                    .setNationality("Croatian")
                    .setYearOfBirth(1979);
            var coach1 = new CoachEntity()
                    .setName("Daniel Vallverdú")
                    .setNationality("Venezuelan")
                    .setYearOfBirth(1986);
            var coach2 = new CoachEntity()
                    .setName("Toni Nadal")
                    .setNationality("Spanish")
                    .setYearOfBirth(1961);
             coachRepository.save(coach);
             coachRepository.save(coach1);
             coachRepository.save(coach2);
             var player = new TennisPlayerEntity()
                     .setFirstName("Roger")
                     .setLastName("Federer")
                     .setAge(41)
                     .setSponsor(adidas)
                     .setCoach(coach)
                     .setRanking(1)
                     .setNationality("Swiss");
            var player2 = new TennisPlayerEntity()
                    .setFirstName("Rafael")
                    .setLastName("Nadal")
                    .setAge(36)
                    .setSponsor(nike)
                    .setCoach(coach1)
                    .setRanking(2)
                    .setNationality("Spanish");
            var player3 = new TennisPlayerEntity()
                    .setFirstName("Grigor")
                    .setLastName("Dimitrov")
                    .setAge(31)
                    .setSponsor(armani)
                    .setCoach(coach2)
                    .setRanking(3)
                    .setNationality("Bulgarian");
            tennisPlayerRepository.save(player);
            tennisPlayerRepository.save(player2);
            tennisPlayerRepository.save(player3);
        }
    }

}
