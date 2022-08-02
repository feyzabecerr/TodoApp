package com.example.todo_app.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table( name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User
{
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )

    private Long id;


    @Email(message = "Incorrect email")
    private String email;


    @NotBlank(message = "Username is mandatory")
    private String username;


    @NotBlank(message = "Password is mandatory")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private List<Task> taskList;

}
