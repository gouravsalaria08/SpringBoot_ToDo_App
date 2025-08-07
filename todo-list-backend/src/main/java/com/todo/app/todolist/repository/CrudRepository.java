package com.todo.app.todolist.repository;

import com.todo.app.todolist.model.CrudOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrudRepository extends JpaRepository<CrudOperations, Integer> {

}
