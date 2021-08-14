package com.example.personalblog.controller;

import com.example.personalblog.entities.User;
import com.example.personalblog.repositories.UserRepository;
import org.springframework.security.config.core.userdetails.UserDetailsResourceFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class RegisterController {

    private final UserRepository userRepository;

    public RegisterController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }


    @PostMapping("/register")
    public String createUser(@ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        // todo: check if input is valid
        user.setRole("USER");
        userRepository.save(user);
        return "redirect:/articles/";
    }
}
