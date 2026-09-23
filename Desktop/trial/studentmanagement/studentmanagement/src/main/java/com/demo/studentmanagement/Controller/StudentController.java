package com.demo.studentmanagement.Controller;

import com.demo.studentmanagement.Entity.Student;
import com.demo.studentmanagement.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/admin/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping("/admin/students")
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/admin/students/{id}")
    public Student updateStudent(
            @PathVariable String id,
            @RequestBody Student studentDetails) {

        return studentService.updateStudent(id, studentDetails);
    }

    @DeleteMapping("/admin/students/{id}")
    public String deleteStudent(@PathVariable String id) {

        studentService.deleteStudent(id);

        return "Student deleted successfully";
    }


    @GetMapping("/student/profile/{id}")
    public Student getStudentProfile(@PathVariable String id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/student/profile/{id}")
    public Student updateStudentProfile(
            @PathVariable String id,
            @RequestBody Student studentDetails) {

        return studentService.updateStudent(id, studentDetails);
    }

    @DeleteMapping("/student/profile/{id}")
    public String deleteStudentProfile(@PathVariable String id) {

        studentService.deleteStudent(id);

        return "Student profile deleted successfully";
    }
}