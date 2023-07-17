package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.AdminEntity;
import com.taslim.trainingmanagementsystem.exception.AdminNotFoundException;
import com.taslim.trainingmanagementsystem.exception.BookNameAuthorNameAlreadyExistsExcepion;
import com.taslim.trainingmanagementsystem.model.AdminRequestModel;
import com.taslim.trainingmanagementsystem.repository.AdminRepository;
import com.taslim.trainingmanagementsystem.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;

    @Override
    public ResponseEntity<Object> createAdmin(AdminRequestModel adminRequestModel) {
        AdminEntity admin = AdminEntity.builder()
                .fullName(adminRequestModel.getFullName())
                .profilePicture(adminRequestModel.getProfilePicture())
                .email(adminRequestModel.getEmail())
                .password(adminRequestModel.getPassword())
                .build();

        AdminEntity savedAdmin = adminRepository.save(admin);
        return ResponseEntity.ok(savedAdmin);
    }

    @Override
    public List<AdminEntity> getAllAdmins() {
        List<AdminEntity> admins = adminRepository.findAll();
        if (admins.isEmpty()) {
            throw new BookNameAuthorNameAlreadyExistsExcepion("No admins found.");
        }
        return admins;
    }

    @Override
    public ResponseEntity<Object> getAdminById(Long id) {
        Optional<AdminEntity> adminOptional = adminRepository.findById(id);
        if (adminOptional.isPresent()) {
            return ResponseEntity.ok(adminOptional.get());
        } else {
            throw new AdminNotFoundException("Admin not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> updateAdmin(Long id, AdminRequestModel adminRequestModel) {
        Optional<AdminEntity> adminOptional = adminRepository.findById(id);
        if (adminOptional.isPresent()) {
            AdminEntity admin = adminOptional.get();
            admin.setFullName(adminRequestModel.getFullName());
            admin.setProfilePicture(adminRequestModel.getProfilePicture());
            admin.setEmail(adminRequestModel.getEmail());
            admin.setPassword(adminRequestModel.getPassword());

            AdminEntity updatedAdmin = adminRepository.save(admin);
            return ResponseEntity.ok(updatedAdmin);
        } else {
            throw new AdminNotFoundException("Admin not found with ID: " + id);
        }
    }

    @Override
    public ResponseEntity<Object> deleteAdmin(Long id) {
        Optional<AdminEntity> adminOptional = adminRepository.findById(id);
        if (adminOptional.isPresent()) {
            adminRepository.deleteById(id);
            return ResponseEntity.ok("Admin with ID: " + id + " has been deleted.");
        } else {
            throw new AdminNotFoundException("Admin not found with ID: " + id);
        }
    }
}
