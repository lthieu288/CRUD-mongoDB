package com.example.demo.services.Impl;

import com.example.demo.data.models.TodoDTO;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final MongoTemplate mongoTemplate;
    private final ModelMapper modelMapper;

    @Override
    public List<TodoDTO> findAll() {
        return mongoTemplate.findAll(TodoDTO.class);
    }

    @Override
    public TodoDTO createTodo(TodoDTO todoDTO) {

        //check if name exist
        Query query = new Query();
        query.addCriteria(Criteria.where("todo").is(todoDTO.getTodo()));
        if(mongoTemplate.findOne(query, TodoDTO.class) != null){
            throw new BadRequestException("Already have name like " + todoDTO.getTodo());
        }

        TodoDTO todo = new TodoDTO();
        todo.setTodo(todoDTO.getTodo());
        todo.setDescription(todoDTO.getDescription());

        todo.setCreatedDate(LocalDateTime.now());
        todo.setCompleted(false);

        return mongoTemplate.save(todo, "todos");
    }

    @Override
    public TodoDTO findByName(String name){

        Query query = new Query();
        query.addCriteria(Criteria.where("todo").is(name));
        TodoDTO todo = mongoTemplate.findOne(query, TodoDTO.class);

        if(todo == null){
            throw new NotFoundException("Not found todo with name: " + name);
        }

        return todo;
    }

    @Override
    public TodoDTO updateTodo(String name, TodoDTO todoDTO) {

        TodoDTO todo = mongoTemplate.findOne(Query.query(Criteria.where("todo").is(name)), TodoDTO.class);

        if(todo == null){
            throw new NotFoundException("Not found todo with name: " + name);
        }

        modelMapper.map(todoDTO, todo);

        return mongoTemplate.save(todo, "todos");
    }

    @Override
    public TodoDTO completeTodo(String name) {

        Query query = new Query();
        query.addCriteria(Criteria.where("todo").is(name));
        Update update = new Update();
        update.set("completed", true);

        return mongoTemplate.findAndModify(query, update, TodoDTO.class);
    }

    @Override
    public TodoDTO deleteTodo(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("todo").is(name));
        TodoDTO todo = mongoTemplate.findOne(query, TodoDTO.class);

        if(todo == null){
            throw new NotFoundException("Not found todo with name: " + name);
        }

        mongoTemplate.remove(todo, "todos");

        return null;
    }
}
