package com.example.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.User;
import com.example.service.UserService;

@RestController
class UserController{
	@Autowired
	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@PostMapping(value="/user/find")
	public Optional<User> findUserById(@RequestParam Long id) {
		return userService.findUserById(id);
		
	}
	
}