package com.example.dao;
public class User{
	private Long Id;
	private String firstName;
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