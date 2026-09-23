package com.demo.studentmanagement.Repository;

import com.demo.studentmanagement.Entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultData extends JpaRepository<Result, String> {

    List<Result> findByStudentId(String studentId);
}