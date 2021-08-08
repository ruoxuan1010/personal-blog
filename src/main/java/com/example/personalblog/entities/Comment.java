package com.example.personalblog.entities;

import com.example.personalblog.entities.Article;
import com.example.personalblog.utils.TimeConverter;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column(length = 150)
    private String content;

    @Convert(converter = TimeConverter.class)
    private LocalDateTime commentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    private Article article;
}
