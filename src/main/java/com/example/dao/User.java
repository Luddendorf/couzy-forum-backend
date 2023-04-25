package com.example.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;
@Entity
public class User{
	@Id
	@GeneratedValue
	private Long Id;
	@Column(name="firstName")
	private String firstName;
	@Column(name="lastName")
	private String lastName;
	public User() {
	}
	public User(Long Id, String firstName, String lastName) {
		super();
		this.Id = Id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public Long getUserId() {
		return Id;
	}
	public void setUserId(Long Id) {
		this.Id = Id;
	}
	public String getFirstName() {
		return firstName;
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
	@Override
	public String toString() {
		return "User [userId=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
}