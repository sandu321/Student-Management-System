package com.demo.studentmanagement.Repository;

import com.demo.studentmanagement.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminData extends JpaRepository<Admin, String> {
}