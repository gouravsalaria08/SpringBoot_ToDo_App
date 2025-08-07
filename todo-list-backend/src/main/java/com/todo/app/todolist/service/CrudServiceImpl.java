package com.todo.app.todolist.service;

import com.todo.app.todolist.model.CrudOperations;
import com.todo.app.todolist.model.TaskStatus;
import com.todo.app.todolist.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CrudServiceImpl implements CrudService {

    @Autowired
    private CrudRepository crudRepository;

    @Override
    public List<CrudOperations> getAllTasks() {
        return crudRepository.findAll();
    }

    @Override
    public Optional<CrudOperations> getTaskById(int id) {
        return crudRepository.findById(id);
    }

    @Override
    public CrudOperations createTask(CrudOperations crudOperations) {
        if (crudOperations.getStatus() == null) {
            crudOperations.setStatus(TaskStatus.PENDING);
        }
        return crudRepository.save(crudOperations);
    }

    @Override
    public Optional<CrudOperations> updateTask(int id, CrudOperations crudOperations) {
        Optional<CrudOperations> optionalTask = crudRepository.findById(id);
        if (optionalTask.isPresent()) {
            CrudOperations existingTask = optionalTask.get();
            existingTask.setTitle(crudOperations.getTitle());
            existingTask.setDescription(crudOperations.getDescription());
            existingTask.setStatus(crudOperations.getStatus());
            CrudOperations updated = crudRepository.save(existingTask);
            return Optional.of(updated);
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteTask(int id) {
        Optional<CrudOperations> optionalTask = crudRepository.findById(id);
        if (optionalTask.isPresent()) {
            crudRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
