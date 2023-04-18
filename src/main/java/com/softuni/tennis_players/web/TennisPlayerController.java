package com.softuni.tennis_players.web;

import com.softuni.tennis_players.domain.dtos.binding.AddTennisPlayerDTO;
import com.softuni.tennis_players.domain.dtos.view.TennisPlayerViewDTO;
import com.softuni.tennis_players.domain.enitities.CoachEntity;
import com.softuni.tennis_players.domain.enitities.SponsorEntity;
import com.softuni.tennis_players.repositories.CoachRepository;
import com.softuni.tennis_players.repositories.SponsorRepository;
import com.softuni.tennis_players.repositories.TennisPlayerRepository;
import com.softuni.tennis_players.services.CoachService;
import com.softuni.tennis_players.services.SponsorService;
import com.softuni.tennis_players.services.TennisPlayerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/")
public class TennisPlayerController {
    private final TennisPlayerService tennisPlayerService;
    private final SponsorRepository sponsorRepository;
    private final CoachRepository coachRepository;
    private final SponsorService sponsorService;
    private final CoachService coachService;
    private final TennisPlayerRepository tennisPlayerRepository;

    public TennisPlayerController(TennisPlayerService tennisPlayerService, SponsorRepository sponsorRepository, CoachRepository coachRepository, SponsorService sponsorService, CoachService coachService, TennisPlayerRepository tennisPlayerRepository) {
        this.tennisPlayerService = tennisPlayerService;
        this.sponsorRepository = sponsorRepository;
        this.coachRepository = coachRepository;
        this.sponsorService = sponsorService;
        this.coachService = coachService;
        this.tennisPlayerRepository = tennisPlayerRepository;
    }
    @GetMapping("/createTennisPlayer")
    public String getPlayer(Model model){
        List<CoachEntity> coaches = coachService.getAllCoaches();
        model.addAttribute("coaches", coaches);
        List<SponsorEntity> sponsors = sponsorService.getAllSponsors();
        model.addAttribute("sponsors",sponsors);
        return "createTennisPlayer";
    }

    @ModelAttribute("addTennisPlayerDTO")
    public AddTennisPlayerDTO init(){
        return new AddTennisPlayerDTO();
    }

    @PostMapping("/createTennisPlayer")
    public String createPlayer(@Valid AddTennisPlayerDTO addTennisPlayerDTO,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes){
        System.out.println(addTennisPlayerDTO.toString());
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("addTennisPlayerDTO",addTennisPlayerDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addTennisPlayerDTO",bindingResult);
           return "redirect:/createTennisPlayer";
        }
        this.tennisPlayerService.addPlayer(addTennisPlayerDTO);
        return "redirect:/alltennisplayers";
    }

    @GetMapping("/alltennisplayers")
    public String getAllPlayers(Model model){
        var allPlayers = tennisPlayerService.getAllPlayers();
        model.addAttribute("players", allPlayers);
        return "alltennisplayers";
    }
    @GetMapping("/details/{id}")
    public String getPlayer(@PathVariable("id") Long playerId, Model model){
        TennisPlayerViewDTO player = tennisPlayerService.getPlayer(playerId);
        model.addAttribute("player",player);
        return "tennisplayer-details";
    }
    @DeleteMapping("details/{id}")
    public String deletePlayer(@PathVariable("id") Long playerId){
        tennisPlayerRepository.deleteById(playerId);
        return "redirect:/alltennisplayers";
    }
}
