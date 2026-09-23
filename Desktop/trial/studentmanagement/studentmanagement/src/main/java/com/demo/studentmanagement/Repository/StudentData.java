package com.demo.studentmanagement.Repository;
import com.demo.studentmanagement.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentData extends JpaRepository<Student, String> {
}
