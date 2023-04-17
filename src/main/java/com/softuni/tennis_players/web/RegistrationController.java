package com.softuni.tennis_players.web;

import com.softuni.tennis_players.domain.dtos.binding.RegistrationDTO;
import com.softuni.tennis_players.services.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @ModelAttribute("registrationDTO")
    public RegistrationDTO init(){
        return new RegistrationDTO();
    }

    @PostMapping("/register")
    public String register(@Valid RegistrationDTO registrationDTO,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes){
        System.out.println(registrationDTO.toString());
        if(bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("registrationDTO", registrationDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.registrationDTO", bindingResult);
            return "redirect:/register";
        }
        this.registrationService.register(registrationDTO);
        return "redirect:/login";
    }
}
