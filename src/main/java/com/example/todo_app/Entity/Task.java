package com.example.todo_app.Entity;

import org.hibernate.annotations.GeneratorType;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity

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

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private boolean isActive;
    protected Task(){

    }

    public Task(String description, LocalDate date, boolean isActive) {
        this.description = description;
        this.date = date;
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


}
