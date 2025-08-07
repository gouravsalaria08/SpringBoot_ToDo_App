package com.todo.app.todolist.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CrudOperations {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING) // ->> this tells jpa to store enum values in database make it more readable
    private TaskStatus status;
}
