package com.example.todo_app.Controller;

import com.example.todo_app.Entity.Profile;
import com.example.todo_app.Repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("profile")
public class ProfileController
{
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping
    public List<Profile> getUsers()
    {
        return profileRepository.findAll();
    }

    // to do...
}
