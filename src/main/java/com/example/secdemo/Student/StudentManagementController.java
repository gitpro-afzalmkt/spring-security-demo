package com.example.secdemo.Student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(new Student(1, "afzal"),
            new Student(2, "qwe"), new Student(3, "zxc"));


    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() { return STUDENTS; }

    @PostMapping
    @PreAuthorize("hasAuthority('course:write')")
    public void registerNewStudent(Student student) { System.out.println(student); }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('course:write')")
    public void deleteStudent(@PathVariable("id") Integer id) { System.out.println(id); }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('course:write')")
    public void updateStudent(@PathVariable("id") Integer id, @RequestBody Student student) { System.out.printf("%s  %s%n", id, student); }

}
