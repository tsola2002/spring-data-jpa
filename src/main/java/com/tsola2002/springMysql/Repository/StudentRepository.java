package com.tsola2002.springMysql.Repository;

import com.tsola2002.springMysql.Entity.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

  // BUILDING OUT A CUSTOM QUERY
  Optional<Student> findStudentByEmail(String email);

}
