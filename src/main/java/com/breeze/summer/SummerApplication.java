package com.breeze.summer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
//(exclude = {DataSourceAutoConfiguration.class})
public class SummerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SummerApplication.class, args);
		System.out.println("Hello");
//		Pupil john = Pupil.builder().name("John").age(15)
//				.status("student")
//				.build();
	}

}
