package com.example.demo.data.models.subMovie;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class Comment {

    @Id
    private String movieId;
    private String name;
    private String email;
    private String text;
    private Date date;
}
