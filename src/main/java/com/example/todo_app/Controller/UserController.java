package com.example.todo_app.Controller;

import com.example.todo_app.Entity.Task;
import com.example.todo_app.Entity.User;
import com.example.todo_app.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profile")
public class UserController
{
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getUsers()
    {
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    User getOneUser(@PathVariable Long id){
        return userRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("user with " + id + " doesn't exist"));
    }
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/{id}/tasks")
    public ResponseEntity<User> addTasktoUser(@PathVariable long id, @RequestBody Task task){
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException());
        user.getTaskList().add(task);
        return ResponseEntity.status(HttpStatus.OK).body(userRepository.save(user));
    }

}
