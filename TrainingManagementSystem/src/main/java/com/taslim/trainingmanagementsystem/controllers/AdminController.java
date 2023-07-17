package com.taslim.trainingmanagementsystem.controllers;

import com.taslim.trainingmanagementsystem.entity.AdminEntity;
import com.taslim.trainingmanagementsystem.model.AdminRequestModel;
import com.taslim.trainingmanagementsystem.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/create")
    public ResponseEntity<Object> createAdmin(@RequestBody AdminRequestModel adminRequestModel) {
        return adminService.createAdmin(adminRequestModel);
    }

    @GetMapping("/all")
    public List<AdminEntity> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAdmin(@PathVariable Long id, @RequestBody AdminRequestModel adminRequestModel) {
        return adminService.updateAdmin(id, adminRequestModel);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAdmin(@PathVariable Long id) {
        return adminService.deleteAdmin(id);
    }
}
