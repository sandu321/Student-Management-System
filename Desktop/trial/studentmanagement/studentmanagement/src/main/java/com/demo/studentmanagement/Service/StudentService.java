package com.demo.studentmanagement.Service;

import com.demo.studentmanagement.Entity.Student;
import com.demo.studentmanagement.Entity.User;
import com.demo.studentmanagement.Repository.StudentData;
import com.demo.studentmanagement.Repository.UserData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentData studentData;
    private final UserData userData;

    public StudentService(StudentData studentData, UserData userData) {
        this.studentData = studentData;
        this.userData = userData;
    }

    public List<Student> getAllStudents() {
        return studentData.findAll();
    }

    public Student addStudent(Student student) {

        Student savedStudent = studentData.save(student);

        User user = new User(
                student.getStudentId(),
                "123456",
                "STUDENT"
        );

        userData.save(user);

        return savedStudent;
    }

    public Student getStudentById(String id) {
        return studentData.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student updateStudent(String id, Student studentDetails) {

        Student student = studentData.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setStudentName(studentDetails.getStudentName());
        student.setEmail(studentDetails.getEmail());
        student.setAddress(studentDetails.getAddress());

        return studentData.save(student);
    }

    public void deleteStudent(String id) {
        studentData.deleteById(id);
    }
}