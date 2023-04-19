package com.example.secdemo.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(new Student(1, "afzal"),
            new Student(2, "qwe"), new Student(3, "zxc"));

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Integer id) {
        return STUDENTS.stream()
                .filter(s -> id.equals(s.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student not found!"));
    }
}
