package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity getUser(String username) {
        return userRepository.findUserEntityByUsername(username)
                .orElseThrow(()->new UsernameNotFoundException(username + " was not found!"));
    }
    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id){
        return userRepository.findUserEntityById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
