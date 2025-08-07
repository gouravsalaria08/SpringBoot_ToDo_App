package com.todo.app.todolist.service;

import com.todo.app.todolist.model.CrudOperations;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface CrudService {

    List<CrudOperations> getAllTasks();

    Optional<CrudOperations> getTaskById(int id);

    CrudOperations createTask(CrudOperations crudOperations);

    Optional<CrudOperations> updateTask(int id, CrudOperations crudOperations);

    boolean deleteTask(int id);
}
