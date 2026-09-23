package com.demo.studentmanagement.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "result")
public class Result {

    @Id
    private String resultId;

    private String studentId;
    private String course;
    private String grade;

    public Result() {
    }

    public Result(String resultId, String studentId, String course, String grade) {
        this.resultId = resultId;
        this.studentId = studentId;
        this.course = course;
        this.grade = grade;
    }

    public String getResultId() {
        return resultId;
    }

    public void setResultId(String resultId) {
        this.resultId = resultId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}