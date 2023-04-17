package com.softuni.tennis_players.web;

import com.softuni.tennis_players.domain.enitities.UserRoleEntity;
import com.softuni.tennis_players.domain.enums.UserRoleEnum;
import com.softuni.tennis_players.repositories.UserRepository;
import com.softuni.tennis_players.repositories.UserRoleRepository;
import com.softuni.tennis_players.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class AdminController {
    private final UserService userService;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    public AdminController(UserService userService,
                           UserRepository userRepository,
                           UserRoleRepository userRoleRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }
    @GetMapping("/admin")
    public String admin(Model model){
        var allUsers = userService.getUsers();
        model.addAttribute("users", allUsers);
        return "admin";
    }
    @DeleteMapping("/remove-roles/admin/{id}")
    public String deleteUser(@PathVariable("id") Long userId){
        userRepository.deleteById(userId);
        return "redirect:/admin";
    }
    @PatchMapping("/remove-roles/admin/{id}")
    public String deleteRole(@PathVariable("id") Long userId){
        var user = userService.getUserById(userId);
        user.setRoles(userRoleRepository.findUserRoleByRole(UserRoleEnum.USER));
        userRepository.save(user);
        return "redirect:/admin";
    }
    @PatchMapping("/add-roles/admin/{id}")
    public String giveAdminRole(@PathVariable("id") Long userId){
        var user = userService.getUserById(userId);
        var admin = new UserRoleEntity().setRole(UserRoleEnum.ADMIN);
        user.setRoles(userRoleRepository.findAll());
        userRepository.save(user);
        return "redirect:/admin";
    }
}
