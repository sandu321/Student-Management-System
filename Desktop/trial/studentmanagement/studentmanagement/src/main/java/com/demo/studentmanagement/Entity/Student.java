package com.demo.studentmanagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    private String studentId;

    private String studentName;
    private String email;
    private String address;

    public Student() {
    }

    public Student(String id, String name, String email, String address) {
        this.studentId = id;
        this.studentName = name;
        this.email = email;
        this.address = address;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
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