package com.example.todo_app.Repository;

import com.example.todo_app.Entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long>
{

}
