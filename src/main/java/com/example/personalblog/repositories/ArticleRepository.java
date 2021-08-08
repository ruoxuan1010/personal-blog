package com.example.personalblog.repositories;

import com.example.personalblog.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticleRepository extends JpaRepository<Article, Long> {
}
