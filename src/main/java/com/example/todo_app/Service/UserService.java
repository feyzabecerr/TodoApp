package com.example.todo_app.Service;


import com.example.todo_app.DTO.UserTaskDTO;
import com.example.todo_app.Entity.User;
import com.example.todo_app.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User getOneUser(Long id) {
        return  userRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("user with " + id + " doesn't exist"));
    }

    public User updateOneUser(Long id, User newUser) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User foundUser = user.get();
            foundUser.setUsername(newUser.getUsername());
            foundUser.setEmail(newUser.getEmail());
            foundUser.setPassword(newUser.getPassword());
            userRepository.save(foundUser);
            return foundUser;
        }
        else{
            throw new IllegalStateException();
        }
    }

    public User getUserById(long id) {
       User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException());
       return user;
    }
}
