package ru.gb.socialnet.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.gb.socialnet.domain.UserProfile;
import ru.gb.socialnet.service.UserProfileService;

import java.util.List;

@Controller
@RequestMapping("/profile")
public class UserProfileController {

    private final UserProfileService userService;

    public UserProfileController(UserProfileService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<UserProfile> users = userService.findAll();
        model.addAttribute("users", users);
        return "all-users";
    }

    @GetMapping("/{id}")
    public String findById(Model model, @PathVariable long id) {
        UserProfile user = userService.findUserProfileById(id);
        model.addAttribute("user", user);
        return "user";
    }
}