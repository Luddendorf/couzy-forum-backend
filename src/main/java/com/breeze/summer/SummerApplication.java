package com.breeze.summer;

import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.breeze.summer.repository.*")
//@ComponentScan(basePackages = { "com.breeze.summer.*" })
//@EntityScan("com.breeze.*") 
//@EnableAutoConfiguration

@SpringBootApplication(exclude= {
		org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
}, scanBasePackages= {"com.breeze.summer"})
@EnableFeignClients
@EnableJpaAuditing
@EnableScheduling
@EnableAsync
public class SummerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerApplication.class, args);
		System.out.println("Hello");
//		Pupil john = Pupil.builder().name("John").age(15)
//				.status("student")
//				.build();
	}

}
