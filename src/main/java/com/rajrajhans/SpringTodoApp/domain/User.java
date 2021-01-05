package com.rajrajhans.SpringTodoApp.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity                             // Telling Hibernate that this is a entity class
public class User {

    @Id                             // Telling Hibernate that "id" property is the primary key
    @GeneratedValue(strategy = GenerationType.AUTO)     // Telling Hibernate that "id" is gonna be auto generated by our database
    private long user_id;

    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "author")                     // mappedBy indicates that this side is the inverse
                                                        // side, and that the mapping is defined by the attribute
                                                        // author at the other side of the association
    private Set<Todo> todos;

    public User() {                 // Doing this because JPA requires a zero arg constructor
    }

    public User(String firstName, String lastName, Set<Todo> todos) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.todos = todos;
    }

    public String getFirstName() {
        return firstName;
    }

    public long getId() {
        return user_id;
    }

    public void setId(long id) {
        this.user_id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }

    @Override
    public boolean equals(Object o) {                               // implementing a custom equals method to make sure
    if (this == o) return true;                                     // that two objects of class "User" are compared based on their ids
        if (o == null || getClass() != o.getClass()) return false;  // so that Hibernate and Set will consider two objects with same id as equal
        User user = (User) o;
        return user_id == user.user_id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }
}
