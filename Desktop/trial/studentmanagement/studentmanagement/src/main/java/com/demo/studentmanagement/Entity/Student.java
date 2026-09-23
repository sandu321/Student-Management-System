package com.demo.studentmanagement.Entity;
import jakarta.persistence.*;

@Entity
@Table(name="student")
public class Student {

    @Id
    private String StudentId;
    private String StudentName;
    private String email;
    private String address;

    public Student(String id,String name,String email,String address){
        this.StudentId=id;
        this.StudentName=name;
        this.email=email;
        this.address=address;
    }

    public String getStudentId() {
        return StudentId;
    }

    public void setStudentId(String studentId) {
        StudentId = studentId;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
