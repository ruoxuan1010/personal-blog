package com.example.personalblog.entities;

import com.example.personalblog.utils.TimeConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 150)
    private String synopsis;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Convert(converter = TimeConverter.class)
    private LocalDateTime publishDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<Comment> comments;
}
