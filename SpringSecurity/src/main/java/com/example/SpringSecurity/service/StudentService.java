package com.example.SpringSecurity.service;

import com.example.SpringSecurity.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Sejal", 30),
            new Student(2, "Varun", 35)
    ));

    public List<Student> getStudents() {
        return students;
    }

    public Boolean addStudent(Student student) {
        return students.add(student);
    }
}
