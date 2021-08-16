package com.example.personalblog.controller;

import com.example.personalblog.entities.Role;
import com.example.personalblog.entities.User;
import com.example.personalblog.repositories.UserRepository;
import com.example.personalblog.utils.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.core.userdetails.UserDetailsResourceFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    public String createUser(@ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", new User());
            return "/register";
        }
        // todo: check if input is valid
        if (userService.findUserByUsername(user.getUsername()) != null) {
            return "error";
        }
        userService.saveUser(user);
        return "redirect:/articles/";
    }
}
