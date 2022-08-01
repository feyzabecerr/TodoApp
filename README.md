# TodoApp
Todo app using Java Spring Boot

### Endpoints 
#### Get Tasks
``` GET /todo HTTP/1.1 Host: localhost:8080 ```

#### Create Task
 ``` POST /todo/ HTTP/1.1 Host: localhost:8080 Content-Type: application/json { "description": "todo..", "date": "yyyy-MM-dd", "active": "false" } ```

#### Get Users
 ``` GET /profile HTTP/1.1 Host: localhost:8080 ```

#### Create User
 ``` POST /profile HTTP/1.1 Host: localhost:8080 Content-Type: application/json { "email": "example@gmail.com", "username": "admin", "password": "12345" } ```

#### Add Task to User
 ``` POST /profile/{id}/tasks HTTP/1.1 Host: localhost:8080 Content-Type: application/json { "description": "todo..", "date": "yyyy-MM-dd", "active": "false" } ```



