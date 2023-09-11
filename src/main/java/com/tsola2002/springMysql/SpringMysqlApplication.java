package com.tsola2002.springMysql;

import com.tsola2002.springMysql.Entity.Student;
import com.tsola2002.springMysql.Repository.StudentRepository;
import java.util.List;
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
			Student maria = new Student("Maria", "Jones", "Maria.Jones@edu", 21);
			Student ahmed = new Student("Ahmed", "Ali", "Ahmed.Ali@edu", 18);
			//studentRepository.save(maria);



			System.out.println("SAVING MARIA & AHMED");
			studentRepository.saveAll(List.of(maria, ahmed));

			System.out.println("USING CUSTOM QUERY");
			studentRepository
					.findStudentByEmail("Ahmed.Ali@edu")
					.ifPresentOrElse(System.out::println, () -> System.out.println("Student with email does not exist"));

//			System.out.println("NUMBER OF STUDENTS: ");
//			System.out.println(studentRepository.count());
//
//			studentRepository
//					.findById(2L)
//					.ifPresentOrElse(
//							System.out::println,
//							() -> System.out.println("Student with ID 2 not found"));
//
//			studentRepository
//					.findById(3L)
//					.ifPresentOrElse(
//							System.out::println,
//							() -> System.out.println("Student with ID 3 not found"));
//
//					System.out.println("SELECT ALL STUDENTS");
//					List<Student> students = studentRepository.findAll();
//					students.forEach(System.out::println);
//
//					System.out.println("DELETE MARIA");
//					studentRepository.deleteById(1L);
//
//					System.out.println("NUMBER OF STUDENTS AFTER DELETE");
//					System.out.println(studentRepository.count());

		};

	};

	}


