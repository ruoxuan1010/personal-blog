package com.example.personalblog.controller;


import com.example.personalblog.entities.Article;
import com.example.personalblog.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/login")
public class LoginController {
//    @GetMapping("")
//    public String getLoginPage(Model model) {
//        model.addAttribute("user", new User());
//        return "login";
//    }
//
//
//    @PostMapping("")
//    public String createArticle(@ModelAttribute Article article, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "error";
//        }
//        if (article.getContent().length() > 150) {
//            article.setSynopsis(article.getContent().substring(0, 150));
//        }
//        article.setSynopsis(article.getContent());
//        article.setPublishDate(LocalDateTime.now());
//        articleRepository.save(article);
//        return "redirect:/articles/" + article.getId();
//    }
}
