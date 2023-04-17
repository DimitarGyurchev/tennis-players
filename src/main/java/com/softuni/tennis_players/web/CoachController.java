package com.softuni.tennis_players.web;

import com.softuni.tennis_players.domain.dtos.model.AddCoachDTO;
import com.softuni.tennis_players.repositories.CoachRepository;
import com.softuni.tennis_players.services.CoachService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class CoachController {
    private final CoachService coachService;
    private final CoachRepository coachRepository;

    public CoachController(CoachService coachService, CoachRepository coachRepository) {
        this.coachService = coachService;
        this.coachRepository = coachRepository;
    }

    @GetMapping("/createCoach")
    public String getCoach() {
        return "createCoach";
    }

    @ModelAttribute("addCoachDTO")
    public AddCoachDTO init() {
        return new AddCoachDTO();
    }

    @PostMapping("/createCoach")
    public String addCoach(@Valid AddCoachDTO addCoachDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        System.out.println(addCoachDTO.toString());
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addCoachDTO", addCoachDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addCoachDTO", bindingResult);
            return "redirect:/createCoach";

        }
        this.coachService.addCoach(addCoachDTO);
        return "redirect:/allcoaches";
    }

    @GetMapping("/allcoaches")
    public String getAllCoaches(Model model) {
        var allCoaches = coachService.getCoaches();
        model.addAttribute("coaches", allCoaches);
        return "allcoaches";
    }
}

