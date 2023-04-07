package com.softuni.tennis_players.web;

import com.softuni.tennis_players.services.TennisPlayerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CatalogController {

    private final TennisPlayerService tennisPlayerService;

    public CatalogController(TennisPlayerService tennisPlayerService) {
        this.tennisPlayerService = tennisPlayerService;
    }

    @GetMapping("/catalog")
    public String showCatalog(Model model) {
        model.addAttribute("players", tennisPlayerService.getAllPlayers());
        return "catalog";
    }
}
