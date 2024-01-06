package com.todo.services;

import com.todo.entity.ToDo;
import com.todo.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;
    public List<ToDo> create(ToDo toDo){
        toDoRepository.save(toDo);
        return list();
    }
    public List<ToDo> list(){
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending());
        return toDoRepository.findAll(sort);
    }
    public List<ToDo> update(ToDo toDo){
        toDoRepository.save(toDo);
        return list();
    }
    public List<ToDo> delete(Long id){
        toDoRepository.deleteById(id);
        return list();
    }
}
