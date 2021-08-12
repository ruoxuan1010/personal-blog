package com.example.personalblog.controller;

import com.example.personalblog.entities.Article;
import com.example.personalblog.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;


@Controller
@RequestMapping("/articles")
public class ArticleController {
    private final ArticleRepository articleRepository;
    private final int SIZE = 8;

    @Autowired
    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    // todo: use services to get rid of detailed implementation
    @RequestMapping("")
    public String showAllArticles(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value="size", defaultValue = "" + SIZE) int size,
                                  Model model) {
        Pageable pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<Article> postsPage = articleRepository.findAll(pageRequest);
        List<Article> articles = postsPage.toList();

        long articlesCount = articleRepository.count();
        int numOfPages = (int) Math.ceil((articlesCount * 1.0) / SIZE);

        model.addAttribute("articles", articles);
        model.addAttribute("articlesCount", articlesCount);
        model.addAttribute("pageRequested", page);
        model.addAttribute("Size", SIZE);
        model.addAttribute("numOfPages", numOfPages);
        return "articles";
    }

    @RequestMapping("/{id}")
    public String getArticleById(@PathVariable String id, Model model) {
        long articleId = Long.parseLong(id);
        Optional<Article> articleOptional = articleRepository.findById(articleId);
        if (articleOptional.isPresent()) {
            model.addAttribute("article", articleOptional.get());
            model.addAttribute("publishDate", articleOptional.get().getPublishDate().toString());
            model.addAttribute("comments", articleOptional.get().getComments());
            model.addAttribute("numOfComments", articleOptional.get().getComments().size());
        } else {
            model.addAttribute("error", "no-article");
        }
        return "article";
    }

    @GetMapping("/edit")
    public String getEditPage(Model model) {
        model.addAttribute("article", new Article());
        return "edit";
    }


    @PostMapping("/edit")
    public String createArticle(@ModelAttribute Article article, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        if (article.getContent().length() > 150) {
            article.setSynopsis(article.getContent().substring(0, 150));
        }
        article.setSynopsis(article.getContent());
        article.setPublishDate(LocalDateTime.now());
        articleRepository.save(article);
        return "redirect:/articles/" + article.getId();
    }

    @DeleteMapping("/{id}")
    public String deleteArticle(@PathVariable long id, Model model) {
//        long articleId = Long.parseLong(id);
        Optional<Article> articleOptional = articleRepository.findById(id);
        if (articleOptional.isPresent()) {
            Article article = articleOptional.get();
            articleRepository.delete(article);
            return "redirect:/articles/";
        }
        return "error";
    }
}
