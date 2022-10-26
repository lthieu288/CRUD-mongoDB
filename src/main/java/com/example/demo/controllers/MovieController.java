package com.example.demo.controllers;

import com.example.demo.data.models.Movie;
import com.example.demo.data.models.TodoDTO;
import com.example.demo.services.Impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieServiceImpl movieService;

    @GetMapping("/movies")
    @ResponseStatus(HttpStatus.OK)
    public Page<Movie> getMovie(@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo,
                                @RequestParam(value = "pageSize", defaultValue = "10", required = false) int pageSize){
        return movieService.findAll(pageNo, pageSize);
    }
    @GetMapping("/movie/{title}")
    @ResponseStatus(HttpStatus.OK)
    public Movie getMovieByTitle (@PathVariable("title") String title) {
        return movieService.findByName(title);
    }

}
