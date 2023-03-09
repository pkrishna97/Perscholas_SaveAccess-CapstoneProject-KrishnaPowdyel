package com.perscholas.krishna.saveaccess.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "myuser")
@NoArgsConstructor
public class Myuser {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "email",  length = 45)
    private String email;

    @Column(name = "password",  length = 45)
    private String password;

    @Column(name = "lastname", length = 45)
    private String lastname;

    @Column(name = "firstname", length = 45)
    private String firstname;

    public Myuser(Integer id, String email, String password, String lastname, String firstname) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
    }
}