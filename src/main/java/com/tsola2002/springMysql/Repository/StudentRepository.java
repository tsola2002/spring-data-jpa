package com.tsola2002.springMysql.Repository;

import com.tsola2002.springMysql.Entity.Student;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends JpaRepository<Student, Long> {

  // BUILDING OUT A CUSTOM QUERY
  @Query("SELECT s FROM Student s WHERE s.email = ?1")
  Optional<Student> findStudentByEmail(String email);


  List<Student> findStudentsByFirstNameEqualsAndAgeEquals(String firstName, Integer age);

  @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age >= ?2")
  List<Student> findStudentsByFirstNameEqualsAndAgeIsGreaterThan(String firstName, Integer age);

  //NATIVE MYSQL QUERY
//  @Query(
//      value = "SELECT * FROM student WHERE firstName = ?1 AND age >= ?2",
//      nativeQuery = true)
//  List<Student> selectStudentWhereFirstNameAndAgeIsGreaterThanOrEqualNative(String firstName, Integer age);

  // NATIVE QUERY USING NAMED PARAMETERS
  @Query(
      value = "SELECT * FROM tbl_student WHERE first_name = :firstName AND age >= :age",
      nativeQuery = true)
  List<Student> selectStudentWhereFirstNameAndAgeIsGreaterThanOrEqualNative(
      @Param("firstName")
      String firstName,
      @Param("age")
      Integer age);

  //DELETING RECORDS USING @MODIFYING
  @Transactional
  @Modifying
  @Query("DELETE FROM Student u WHERE u.id = ?1")
  int deleteStudentById(Long id);

}
