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

    @Column(nullable = false)
    private String title;

    @Column(length = 150)
    private String synopsis;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Convert(converter = TimeConverter.class)
    private LocalDateTime publishDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<Comment> comments;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
