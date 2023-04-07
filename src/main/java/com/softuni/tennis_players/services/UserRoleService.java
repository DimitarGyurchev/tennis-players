package com.softuni.tennis_players.services;

import com.softuni.tennis_players.domain.dtos.model.UserRoleModel;
import com.softuni.tennis_players.domain.dtos.view.UserRoleViewDTO;
import com.softuni.tennis_players.domain.enums.UserRoleEnum;
import com.softuni.tennis_players.repositories.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Order(0)
@Service
public class UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    public UserRoleService(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
    }
    public List<UserRoleViewDTO> getAll() {
        return this.userRoleRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, UserRoleViewDTO.class))
                .collect(Collectors.toList());
    }

    public List<UserRoleModel> findAllRoles() {
        return this.userRoleRepository.findAll()
                .stream()
                .map(r -> this.modelMapper.map(r, UserRoleModel.class))
                .collect(Collectors.toList());
    }

    public UserRoleModel findRoleByName(String name) {
        return this.modelMapper.map(this.userRoleRepository.findByRole(UserRoleEnum.valueOf(name))
                        .orElseThrow(NoSuchElementException::new),
                UserRoleModel.class);
    }
}

