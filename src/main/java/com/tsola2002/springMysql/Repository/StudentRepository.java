package com.tsola2002.springMysql.Repository;

import com.tsola2002.springMysql.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
