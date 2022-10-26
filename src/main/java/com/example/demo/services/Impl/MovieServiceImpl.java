package com.example.demo.services.Impl;

import com.example.demo.data.models.Movie;
import com.example.demo.data.models.TodoDTO;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.services.MovieService;
import com.example.demo.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MongoTemplate mongoTemplate;
    private final ModelMapper modelMapper;


    @Override
    public Page<Movie> findAll(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Query query = new Query().with(pageable);

        List<Movie> list = mongoTemplate.find(query, Movie.class, "movies");

        Page<Movie> moviePage = PageableExecutionUtils.getPage(
                list,
                pageable,
                ()-> mongoTemplate.count(query, Movie.class)
        );


        return moviePage;
    }

    @Override
    public TodoDTO createTodo(TodoDTO todoDTO) {
        return null;
    }

    @Override
    public Movie findByName(String name) {

        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(new ObjectId("573a13fbf29313caabdeefd2")));

        Movie movie = mongoTemplate.findOne(query, Movie.class);
        return movie;
    }

    @Override
    public TodoDTO updateTodo(String name, TodoDTO todoDTO) {
        return null;
    }

    @Override
    public Movie createMovie() {
        return null;
    }

    @Override
    public TodoDTO completeTodo(String name) {
        return null;
    }
}
