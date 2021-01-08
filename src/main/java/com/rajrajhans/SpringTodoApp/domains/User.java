package com.rajrajhans.SpringTodoApp.domains;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity                             // Telling Hibernate that this is a entity class
public class User {

    @Id                             // Telling Hibernate that "id" property is the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)     // Telling Hibernate that "id" is gonna be auto generated by our database
    private long id;

    private String username;
    private String password;
    private String role;
    boolean active;

    @OneToMany(mappedBy = "author")                     // mappedBy indicates that this side is the inverse
                                                        // side, and that the mapping is defined by the attribute
                                                        // author at the other side of the association
    private Set<Todo> todos;

    public User() {                 // Doing this because JPA requires a zero arg constructor
    }

    public User(String username, String password, String userRole) {
        this.username = username;
        this.password = password;
        this.role = userRole;
        this.active = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {                               // implementing a custom equals method to make sure
    if (this == o) return true;                                     // that two objects of class "User" are compared based on their ids
        if (o == null || getClass() != o.getClass()) return false;  // so that Hibernate and Set will consider two objects with same id as equal
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + username + '\'' +
                ", lastName='" + password + '\'' +
                ", todos=" + todos +
                '}';
    }
}
