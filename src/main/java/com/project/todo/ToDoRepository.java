package com.project.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {
    // Find all ToDos ordered by createdAt in descending order
    List<ToDo> findAllByOrderByCreatedAtDesc();
}
