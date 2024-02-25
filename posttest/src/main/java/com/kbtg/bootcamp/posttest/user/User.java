package com.kbtg.bootcamp.posttest.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user", schema = "public")
public class User {

    @Id
    @NotNull
    @Size(min = 10, max = 10, message = "User id must be a 10-digit string")
    @Column(name = "user_id")
    private String id;
    @Column(name = "username")
    private String username;

    public User() {

    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public User(String id, String username) {
        this.id = id;
        this.username = username;
    }
}
