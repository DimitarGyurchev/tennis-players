package com.softuni.tennis_players.web;

import com.softuni.tennis_players.domain.dtos.model.TennisPlayerModel;
import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import com.softuni.tennis_players.services.TennisPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/players")
public class DetailsController {

    private final TennisPlayerService tennisPlayerService;

    @Autowired
    public DetailsController(TennisPlayerService tennisPlayerService) {
        this.tennisPlayerService = tennisPlayerService;
    }

    @GetMapping("/{id}")
    public String playerDetails(@PathVariable("id") long id, Model model) {
        Optional<TennisPlayerEntity> optionalPlayer = tennisPlayerService.getPlayerById(id);
        if (optionalPlayer.isPresent()) {
            TennisPlayerEntity player = optionalPlayer.get();
            model.addAttribute("player", player);
            return "details";
        } else {
            // handle player not found error TODO !!!
            return "error";
        }
    }

}