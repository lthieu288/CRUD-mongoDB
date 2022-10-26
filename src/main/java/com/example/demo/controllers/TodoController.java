package com.example.demo.controllers;

import com.example.demo.data.models.TodoDTO;
import com.example.demo.services.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/todos")
    @ResponseStatus(HttpStatus.CREATED)
    public TodoDTO createTodo (@RequestBody @Valid TodoDTO todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping("/todos")
    @ResponseStatus(HttpStatus.OK)
    public List<TodoDTO> getAllTodos(){
        return todoService.findAll();
    }

    @GetMapping("/todo/{name}")
    @ResponseStatus(HttpStatus.OK)
    public TodoDTO getTodoByName (@PathVariable("name") String name) {
        return todoService.findByName(name);
    }

    @PutMapping("/todo/{name}")
    @ResponseStatus(HttpStatus.OK)
    public TodoDTO updateTodo (@PathVariable("name") String name, @RequestBody @Valid TodoDTO todoDTO) {
        return todoService.updateTodo(name, todoDTO);
    }

    @PutMapping("/todo/complete/{name}")
    @ResponseStatus(HttpStatus.OK)
    public TodoDTO completeTodo (@PathVariable("name") String name) {
        return todoService.completeTodo(name);
    }

    @DeleteMapping("/todo/{name}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public TodoDTO deleteTodo (@PathVariable("name") String name) {
        return todoService.deleteTodo(name);
    }
}
