package com.todo.controllers;

import com.todo.entity.ToDo;
import com.todo.services.ToDoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;
    @PostMapping
    List<ToDo> create(@Valid @RequestBody ToDo toDo){
        return toDoService.create(toDo);
    }
    @GetMapping
    List<ToDo> list(){
        return toDoService.list();
    }
    @PutMapping
    List<ToDo> update(@RequestBody ToDo toDo){
       return toDoService.update(toDo);
    }
    @DeleteMapping("/{id}")
    List<ToDo> delete(@PathVariable("id") Long id){
        return toDoService.delete(id);
    }
}
