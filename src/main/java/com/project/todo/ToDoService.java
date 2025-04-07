package com.project.todo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    // Create a new ToDo
    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    // Get all ToDos ordered by creation date (descending)
    public List<ToDo> getAllToDosOrderByCreatedAtDesc() {
        return toDoRepository.findAllByOrderByCreatedAtDesc();
    }

    // Mark a ToDo as completed
    public ToDo markToDoAsCompleted(Long id) {
        ToDo toDo = toDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ToDo not found with id: " + id));

        toDo.setCompleted(true);
        return toDoRepository.save(toDo);
    }
}
