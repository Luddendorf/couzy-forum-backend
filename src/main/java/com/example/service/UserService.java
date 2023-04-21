package com.example.service;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.User;
import com.example.repository.UserRepository;
@Service
public class UserService {
	@Autowired
	private final UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> findUserById(Long userId) {
		return userRepository.findById(userId);
	}
	
}