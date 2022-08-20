package com.example.todo_app.Service;

import com.example.todo_app.DTO.UserTaskDTO;
import com.example.todo_app.Entity.Task;
import com.example.todo_app.Entity.User;
import com.example.todo_app.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;

    private UserService userService;

    public TaskService(TaskRepository taskRepository, UserService userService) {
        this.taskRepository = taskRepository;
        this.userService = userService;
    }

    public List<Task> getAllTasks(Optional<Long> userId) {
        if(userId.isPresent())
            return taskRepository.findByUserId(userId.get());

        return taskRepository.findAll();
    }

    public Task getOneTask(Long taskId) {
        return taskRepository.findById(taskId).
                orElseThrow(() -> new IllegalStateException("task with " + taskId + " doesn't exist"));
    }

    public Task updateOneTask(Long taskId, UserTaskDTO userTaskDTO) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isPresent()){
            Task toUpdate = task.get();
            toUpdate.setDescription(userTaskDTO.getDescription());
            System.out.println(userTaskDTO.getDescription());
            toUpdate.setDate(userTaskDTO.getDate());
            toUpdate.setActive(userTaskDTO.isActive());

            taskRepository.save(toUpdate);

            return toUpdate;
        }
        else{
            throw new IllegalStateException();
        }
    }

    public Task createOneTask(UserTaskDTO userTaskDTO) {
        User user = userService.getOneUser(userTaskDTO.getUserId());
        if(user == null)
            return null;

        Task task = new Task();
        task.setActive(userTaskDTO.isActive());
        task.setDate(userTaskDTO.getDate());
        task.setDescription(userTaskDTO.getDescription());
        task.setUser(user);
        return taskRepository.save(task);
    }
}
