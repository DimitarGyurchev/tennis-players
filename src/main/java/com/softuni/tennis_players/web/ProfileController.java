package com.softuni.tennis_players.web;

import com.softuni.tennis_players.domain.dtos.binding.UserProfileDTO;
import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class ProfileController {
    private final UserService userService;

    public ProfileController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model){
        String username = principal.getName();
        UserEntity userEntity = userService.getUser(username);
        UserProfileDTO userProfileDTO = new UserProfileDTO()
                .setUsername(username)
                .setEmail(userEntity.getEmail())
                .setFullName(userEntity.getFullName());
        model.addAttribute("user",userProfileDTO);
        return "profile";
    }
}
