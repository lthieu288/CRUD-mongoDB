package com.example.demo.data.models.subMovie;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Imdb {
    @Id
    private String id;
    private Double rating;
    private Integer votes;
}
