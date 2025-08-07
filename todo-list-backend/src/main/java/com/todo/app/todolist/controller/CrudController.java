package com.todo.app.todolist.controller;

import com.todo.app.todolist.model.CrudOperations;
import com.todo.app.todolist.model.TaskStatus;
import com.todo.app.todolist.repository.CrudRepository;
import com.todo.app.todolist.service.CrudService;
import com.todo.app.todolist.service.CrudServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api")
public class CrudController {

    @Autowired
    CrudRepository crudRepository;

    @Autowired
    CrudService crudService;

    @GetMapping
    public List<CrudOperations> getAllTasks(){
        return crudService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CrudOperations> getTaskById(@PathVariable int id){

        return crudService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() ->ResponseEntity.notFound().build());

    }

    @PostMapping("/add")
    public CrudOperations createTask(@RequestBody CrudOperations crudOperations){
        return crudService.createTask(crudOperations);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CrudOperations> updateTask(@PathVariable int id,@RequestBody CrudOperations crudOperations){
        return crudService.updateTask(id, crudOperations)
                .map(task -> new ResponseEntity<>(task, HttpStatus.OK))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable int id){
        if(crudService.deleteTask(id)){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
