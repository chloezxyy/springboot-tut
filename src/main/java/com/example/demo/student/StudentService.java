package com.example.demo.student;

// where the business logic lies

import jakarta.transaction.Transactional; // should use jakarta?
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service // spring bean that has to be instantiated
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        // if the email is present, then throw exception
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student with id " + studentId + " does not exist in db");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional // when we use this annotation, we dont have to use jbql query to update the student
    public void updateStudent(Long studentId, String name, String email) {
        // put request to update student details
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("student with id " + studentId + " does not exist in db"));

        if (name != null &&
                !name.isEmpty() &&
                // check if its not the same name as the one in db
                !Objects.equals(student.getName(), name)
        ) {
            student.setName(name);
        }
        if (email != null && !email.isEmpty() &&
                // check if its not the same name as the one in db
                !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email taken");
            }
            student.setEmail(email);
        }
    }
}
