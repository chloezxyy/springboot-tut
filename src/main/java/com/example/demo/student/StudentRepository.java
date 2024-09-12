package com.example.demo.student;

// Data access layer

// anything that access the database with jpa

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // similar to @Service, @Component, @Controller - its called Repository because its responsible for data access
public interface StudentRepository extends JpaRepository<Student, Long> {

    // find a user by email
    // this translates to SELECT * FROM student WHERE email = ?
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
