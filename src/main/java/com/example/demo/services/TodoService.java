package com.example.demo.services;

import com.example.demo.data.models.TodoDTO;

import java.util.List;

public interface TodoService {
    List<TodoDTO> findAll ();
    TodoDTO createTodo (TodoDTO todoDTO);
    TodoDTO findByName (String name);
    TodoDTO updateTodo (String name, TodoDTO todoDTO);
    TodoDTO deleteTodo (String name);
    TodoDTO completeTodo (String name);
}
