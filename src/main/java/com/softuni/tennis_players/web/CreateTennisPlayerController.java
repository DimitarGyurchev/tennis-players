package com.softuni.tennis_players.web;

import com.softuni.tennis_players.domain.dtos.model.TennisPlayerModel;
import com.softuni.tennis_players.services.TennisPlayerService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/players")
public class CreateTennisPlayerController {
    
    @Autowired
    private TennisPlayerService tennisPlayerService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("tennis_player", new TennisPlayerModel());
        return "createTennisPlayer";
    }
    @PostMapping("/create")
    public String createPlayer(@ModelAttribute("tennis_player") TennisPlayerModel tennisPlayer) {
        tennisPlayerService.createPlayer(tennisPlayer);
        return "redirect:/players";
    }

}
