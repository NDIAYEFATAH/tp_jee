package sn.dev.listtodo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;
    @ManyToOne
    @JoinColumn(name = "list_id")
    private ToDoList todolist;
    private String post;
}
