package com.example.todo_app.Repository;

import com.example.todo_app.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {

}
