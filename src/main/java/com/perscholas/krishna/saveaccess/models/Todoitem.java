package com.perscholas.krishna.saveaccess.models;

import com.perscholas.krishna.saveaccess.models.Myuser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "todoitems")
@NoArgsConstructor
public class Todoitem {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "text", nullable = false, length = 45)
    private String text;

    @Column(name = "completed", nullable = false)
    private Boolean completed;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private Myuser user;

    public Todoitem(String text, Myuser user) {
        this.text = text;
        this.completed = false;
        this.user = user;
    }
}