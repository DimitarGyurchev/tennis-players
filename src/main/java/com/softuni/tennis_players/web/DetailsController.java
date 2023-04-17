package com.softuni.tennis_players.web;

import com.softuni.tennis_players.domain.dtos.model.TennisPlayerModel;
import com.softuni.tennis_players.domain.enitities.TennisPlayerEntity;
import com.softuni.tennis_players.domain.enitities.UserEntity;
import com.softuni.tennis_players.services.TennisPlayerService;
import com.softuni.tennis_players.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/players")
public class DetailsController {
}
//    private final TennisPlayerService tennisPlayerService;
//    private final UserService userService;
//
//    @Autowired
//    public DetailsController(TennisPlayerService tennisPlayerService, UserService userService) {
//        this.tennisPlayerService = tennisPlayerService;
//        this.userService = userService;
//    }

//    @GetMapping("/{id}")
//    public String playerDetails(@PathVariable("id") long id, Model model) {
//        Optional<TennisPlayerEntity> optionalPlayer = tennisPlayerService.getPlayerById(id);
//        if (optionalPlayer.isPresent()) {
//            TennisPlayerEntity player = optionalPlayer.get();
//            model.addAttribute("player", player);
//            return "details";
//        } else {
//             handle player not found error TODO !!!
//            return "error";
//        }
//    }

//    @GetMapping("/details/{id}")
//    public String getPlayerDetails(@PathVariable("id") Long id, Model model) {
//        Optional<TennisPlayerEntity> optionalPlayer = tennisPlayerService.getPlayerById(id);
//        if (optionalPlayer.isPresent()) {
//            TennisPlayerEntity player = optionalPlayer.get();
//            model.addAttribute("player", player);
//        } else {
//            // handle player not found error TODO !!!
//            return "error";
//        }
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        String loggedInUsername = auth.getName();
//        Optional<UserEntity> optionalLoggedInUser = userService.findByUsername(loggedInUsername);
//
//        if (optionalLoggedInUser.isPresent()) {
//            UserEntity loggedInUserEntity = optionalLoggedInUser.get();
//            model.addAttribute("loggedInUser", loggedInUserEntity);
//        } else {
//            // handle user not found error TODO !!!
//            return "error";
//        }
//
//        return "details";
//    }

//
//    @PostMapping("/delete/{id}")
//    public String deletePlayer(@PathVariable("id") Long id) {
//        tennisPlayerService.deletePlayer(id);
//        return "redirect:/players";
//    }
//
//}
