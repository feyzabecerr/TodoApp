package com.example.todo_app.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task {
    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "my_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )

    private Long id;


    @NotBlank(message = "Description is mandatory")
    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private boolean isActive;

}
