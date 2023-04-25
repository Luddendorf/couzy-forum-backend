package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.repository.UserRepository;

@Configuration
@EnableJpaRepositories("com.example.repository")
public class UserConfig {
	
}