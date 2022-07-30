package com.example.todo_app.Controller;

import com.example.todo_app.Entity.Task;
import com.example.todo_app.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class TaskController {
    @Autowired
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getTasks(){
        return taskRepository.findAll();
    }

    @PostMapping
    ResponseEntity<Task> createTask(@RequestBody Task task){
        taskRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }

}
