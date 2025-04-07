package com.project.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    @Autowired
    private ToDoService toDoService;

    // Create a new ToDo item
    @PostMapping("/add")
    public ResponseEntity<ToDo> createToDo(@RequestBody ToDo toDo) {
        ToDo createdToDo = toDoService.createToDo(toDo);
        return new ResponseEntity<>(createdToDo, HttpStatus.CREATED);
    }

    // Get all ToDo items sorted by creation date (descending)
    @GetMapping("/get")
    public ResponseEntity<List<ToDo>> getAllToDos() {
        List<ToDo> todos = toDoService.getAllToDosOrderByCreatedAtDesc();
        return new ResponseEntity<>(todos, HttpStatus.OK);
    }

    // Update ToDo status (mark as completed)
    @PatchMapping("/{id}/complete")
    public ResponseEntity<ToDo> markToDoAsCompleted(@PathVariable Long id) {
        ToDo updatedToDo = toDoService.markToDoAsCompleted(id);
        return new ResponseEntity<>(updatedToDo, HttpStatus.OK);
    }
}
