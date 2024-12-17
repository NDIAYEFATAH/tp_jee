package sn.dev.listtodo.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
public class ToDoList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int listId;
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "todolist", cascade = CascadeType.ALL)
    private List<Task> tasks;
}
