package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    Collection<Student> getAll() {
        return studentService.getAll();
    }
    @GetMapping("/age")
    Collection<Student> getAllByAge(@RequestParam int age) {
        return studentService.getAllByAge(age);
    }
    @GetMapping("/{id}")
    public Student getStudentInfo(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        studentService.createStudent(student);
        return student;
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }
    @DeleteMapping({"/id"})
    public Student deleteStudent(@RequestParam Long id) {
        return studentService.deleteStudent(id);
    }
}
