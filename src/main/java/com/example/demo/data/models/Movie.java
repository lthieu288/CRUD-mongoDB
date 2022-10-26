package com.example.demo.data.models;

import com.example.demo.data.models.subMovie.Comment;
import com.example.demo.data.models.subMovie.Imdb;
import com.example.demo.data.models.subMovie.Tomatoes;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movies")
public class Movie {
    @Id
    private String id;
    private List<String> cast;
    private List<String> directors;
    private List<String> countries;
    private String fullPlot;
    private List<String> genres;
    private Imdb imdb;
    private String plot;
    private Integer runtime;
    private String title;
    private Tomatoes tomatoes;
    private String type;
    private List<String> writers;
    private Integer year;
    private LocalDateTime lastUpdated;
    private String released;
    private Integer numMFLixComments;
    private List<Comment> comments;
}
