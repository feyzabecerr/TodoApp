package com.example.todo_app.Controller;

import com.example.todo_app.DTO.UserTaskDTO;
import com.example.todo_app.Entity.Task;
import com.example.todo_app.Repository.TaskRepository;
import com.example.todo_app.Service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private final TaskService taskService;
    @Autowired
    private final TaskRepository taskRepository;

    public TaskController(TaskService taskService, TaskRepository taskRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public List<Task> getTasks(@RequestParam Optional<Long> userId){
        return taskService.getAllTasks(userId);
    }

    @GetMapping("/{id}")
    public Task getOneTask(@PathVariable Long id){
        return taskService.getOneTask(id);
    }
    @PostMapping
    ResponseEntity<UserTaskDTO> createTask(@Valid @RequestBody UserTaskDTO userTaskDTO){
        taskService.createOneTask(userTaskDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userTaskDTO);
    }

    @PutMapping("/{id}")
    public Task updateOneTask(@PathVariable Long id,@RequestBody UserTaskDTO userTaskDTO){
        return taskService.updateOneTask(id,userTaskDTO);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
