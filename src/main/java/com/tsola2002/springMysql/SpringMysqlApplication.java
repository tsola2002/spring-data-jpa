package com.tsola2002.springMysql;

import com.tsola2002.springMysql.Entity.Student;
import com.tsola2002.springMysql.Repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {
			Student maria = new Student("Maria", "Jones", "Maria.Jones@edu", 21
			);
			studentRepository.save(maria);
		};

	}

}
