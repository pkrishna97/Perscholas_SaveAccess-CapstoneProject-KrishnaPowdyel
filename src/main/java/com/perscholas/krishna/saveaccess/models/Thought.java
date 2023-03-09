package com.perscholas.krishna.saveaccess.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "thought")
@NoArgsConstructor
public class Thought {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "text", nullable = false, length = 45)
    private String text;

    @Column(name = "category", nullable = false, length = 45)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Myuser user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "todoitems_id", nullable = false)
    private Todoitem todoitems;

    public Thought(Integer id, String text, String category, Myuser user, Todoitem todoitems) {
        this.id = id;
        this.text = text;
        this.category = category;
        this.user = user;
        this.todoitems = todoitems;
    }
}