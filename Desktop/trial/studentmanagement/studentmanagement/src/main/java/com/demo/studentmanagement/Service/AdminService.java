package com.demo.studentmanagement.Service;

import com.demo.studentmanagement.Entity.Admin;
import com.demo.studentmanagement.Repository.AdminData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    private final AdminData adminData;

    public AdminService(AdminData adminData) {
        this.adminData = adminData;
    }

    public List<Admin> getAllAdmins() {
        return adminData.findAll();
    }

    public Admin addAdmin(Admin admin) {
        return adminData.save(admin);
    }

    public Admin getAdminById(String id) {
        return adminData.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));
    }

    public Admin updateAdmin(String id, Admin adminDetails) {

        Admin admin = adminData.findById(id)
                .orElseThrow(() -> new RuntimeException("Admin not found"));

        admin.setAdminName(adminDetails.getAdminName());
        admin.setEmail(adminDetails.getEmail());
        admin.setPassword(adminDetails.getPassword());

        return adminData.save(admin);
    }

    public void deleteAdmin(String id) {
        adminData.deleteById(id);
    }
}