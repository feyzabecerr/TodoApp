package com.example.todo_app.Controller;

import com.example.todo_app.Entity.Task;
import com.example.todo_app.Entity.User;
import com.example.todo_app.Repository.UserRepository;
import com.example.todo_app.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController
{
    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @GetMapping
    public List<User> getUsers()
    {
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    User getOneUser(@PathVariable Long id){
        return userService.getOneUser(id);
    }
    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("/{id}")
    public User updateOneUser(@PathVariable Long id, @RequestBody User newUser){
       return userService.updateOneUser(id,newUser);
    }

    @PostMapping("/{id}/tasks")
    public ResponseEntity<User> addTasktoUser(@Valid @PathVariable long id, @RequestBody Task task){
        User user = userService.getUserById(id);
        user.getTaskList().add(task);
        return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(user));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.noContent().build();
    }

}
