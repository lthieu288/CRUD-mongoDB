package com.example.demo.services;

import com.example.demo.data.models.Movie;
import com.example.demo.data.models.TodoDTO;
import org.springframework.data.domain.Page;


public interface MovieService {
    Page<Movie> findAll (int pageNo, int pageSize);
    TodoDTO createTodo (TodoDTO todoDTO);
    Movie findByName (String name);
    TodoDTO updateTodo (String name, TodoDTO todoDTO);
    Movie createMovie ();
    TodoDTO completeTodo (String name);

}
