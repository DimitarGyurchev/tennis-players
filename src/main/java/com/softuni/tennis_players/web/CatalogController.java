package com.softuni.tennis_players.web;


import com.softuni.tennis_players.domain.dtos.binding.TennisPlayerDTO;
import com.softuni.tennis_players.domain.dtos.binding.UserDTO;
import com.softuni.tennis_players.domain.dtos.model.TennisPlayerModel;
import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import com.softuni.tennis_players.repositories.TennisPlayerRepository;
import com.softuni.tennis_players.repositories.UserRepository;
import com.softuni.tennis_players.services.ApplicationUserDetailsService;
import com.softuni.tennis_players.services.TennisPlayerService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class CatalogController {
    private final UserRepository userRepository;
    private final TennisPlayerRepository playerRepository;
    private final TennisPlayerService tennisPlayerService;

    public CatalogController(TennisPlayerRepository playerRepository, UserRepository userRepository, TennisPlayerService tennisPlayerService) {
        this.playerRepository = playerRepository;
        this.userRepository = userRepository;
        this.tennisPlayerService = tennisPlayerService;
    }
    @GetMapping("/catalog")
    public String getCatalog(Model model) {
        List<TennisPlayerDTO> players = tennisPlayerService.getAllPlayers();
        model.addAttribute("players", players);
        return "catalog";
    }



}
