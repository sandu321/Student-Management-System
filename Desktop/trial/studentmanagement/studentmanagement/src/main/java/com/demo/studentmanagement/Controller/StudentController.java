package com.demo.studentmanagement.Controller;
import com.demo.studentmanagement.Entity.Student;
import com.demo.studentmanagement.Repository.StudentData;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
    private final StudentData studentData;

    public StudentController(StudentData studentData) {
        this.studentData = studentData;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentData.findAll();
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentData.save(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {
        return studentData.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable String id,
            @RequestBody Student studentDetails) {

        Student student = studentData.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setStudentId(studentDetails.getStudentId());
        student.setStudentName(studentDetails.getStudentName());
        student.setEmail(studentDetails.getEmail());
        student.setAddress(studentDetails.getAddress());

        return studentData.save(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable String id) {

        studentData.deleteById(id);

        return "Student deleted successfully";
    }


}
