package com.demo.studentmanagement.Controller;

import com.demo.studentmanagement.Entity.Admin;
import com.demo.studentmanagement.Service.AdminService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @PostMapping
    public Admin addAdmin(@RequestBody Admin admin) {
        return adminService.addAdmin(admin);
    }

    @GetMapping("/{id}")
    public Admin getAdmin(@PathVariable String id) {
        return adminService.getAdminById(id);
    }

    @PutMapping("/{id}")
    public Admin updateAdmin(
            @PathVariable String id,
            @RequestBody Admin adminDetails) {

        return adminService.updateAdmin(id, adminDetails);
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable String id) {

        adminService.deleteAdmin(id);

        return "Admin deleted successfully";
    }
}