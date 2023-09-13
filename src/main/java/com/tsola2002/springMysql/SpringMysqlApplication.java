package com.tsola2002.springMysql;

import com.github.javafaker.Faker;
import com.tsola2002.springMysql.Entity.Student;
import com.tsola2002.springMysql.Repository.StudentRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@SpringBootApplication
public class SpringMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMysqlApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository){
		return args -> {

			generateRandomStudents(studentRepository);

			PageRequest pageRequest = PageRequest.of(
					0,
					5,
					 Sort.by("firstName").ascending());
			     Page<Student> page = studentRepository.findAll(pageRequest);
			System.out.println(page);

//			Student maria = new Student("Maria", "Jones", "Maria.Jones@edu", 21);
//			Student maria2 = new Student("Maria", "Jones", "Maria.Jones@edu", 25);
//			Student ahmed = new Student("Ahmed", "Ali", "Ahmed.Ali@edu", 18);

			//studentRepository.save(maria);


//			System.out.println("SAVING MARIA & AHMED");
//			studentRepository.saveAll(List.of(maria, maria2, ahmed));
//
//			System.out.println("DELETING MARIA WITH ID 2");
//			System.out.println(studentRepository.deleteStudentById(3L));

//			System.out.println("USING NATIVE QUERIES & NAMED PARAMETERS");
//			studentRepository.selectStudentWhereFirstNameAndAgeIsGreaterThanOrEqualNative(
//					"Maria2",
//					25
//			).forEach(System.out::println);

//			System.out.println("USING NATIVE QUERIES");
//			studentRepository.selectStudentWhereFirstNameAndAgeIsGreaterThanOrEqualNative(
//					"Maria2",
//					25
//			).forEach(System.out::println);

//			System.out.println("USING CUSTOM QUERY2");
//			studentRepository.findStudentsByFirstNameEqualsAndAgeEquals(
//					"Maria2",
//					25
//			).forEach(System.out::println);

//			studentRepository.findStudentsByFirstNameEqualsAndAgeIsGreaterThan(
//					"Maria",
//					19
//			).forEach(System.out::println);

//			System.out.println("USING CUSTOM QUERY");
//			studentRepository
//					.findStudentByEmail("Ahmed.Ali@edu")
//					.ifPresentOrElse(System.out::println, () -> System.out.println("Student with email does not exist"));

//			System.out.println("NUMBER OF STUDENTS: ");
//			System.out.println(studentRepository.count());
//
//			studentRepository
//					.findById(2L)
//					.ifPresentOrElse(
//							System.out::println,
//							() -> System.out.println("Student with ID 2 not found"));


//			studentRepository
//					.findById(3L)
//					.ifPresentOrElse(
//							System.out::println,
//							() -> System.out.println("Student with ID 3 not found"));


//					System.out.println("SELECT ALL STUDENTS");
//					List<Student> students = studentRepository.findAll();
//					students.forEach(System.out::println);

//					System.out.println("DELETE MARIA");
//					studentRepository.deleteById(1L);

//					System.out.println("NUMBER OF STUDENTS AFTER DELETE");
//					System.out.println(studentRepository.count());

		};

	}

	private static void  generateSorting(StudentRepository studentRepository) {
		//			Sort sort = Sort.by(Direction.ASC, "firstName");
		Sort sort = Sort.by("firstName")
				.ascending()
				.and(Sort.by("age").descending());
		studentRepository.findAll(sort)
				.forEach(student -> System.out.println(student.getFirstName() + " " + student.getAge()));
	}

	private static void generateRandomStudents(StudentRepository studentRepository) {
		Faker faker = new Faker();
		for (int i = 0; i <  20 ; i++) {
			String firstName = faker.name().firstName();
			String lastName = faker.name().lastName();
			String email = String.format("%s.%s@amigoscode.edu", firstName, lastName);
			Student student = new Student(
					firstName,
					lastName,
					email,
					faker.number().numberBetween(17, 55));
			studentRepository.save(student);
		}
	}

	;

	}


