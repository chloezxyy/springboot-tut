package com.example.demo.student;

// Data access layer

// anything that access the database with jpa

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // similar to @Service, @Component, @Controller - its called Repository because its responsible for data access
public interface StudentRepository extends JpaRepository<Student, Long> {
}
