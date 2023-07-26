package com.taslim.trainingmanagementsystem.service.impl;

import com.taslim.trainingmanagementsystem.entity.AdminEntity;
import com.taslim.trainingmanagementsystem.utils.Role;
import com.taslim.trainingmanagementsystem.exception.*;
import com.taslim.trainingmanagementsystem.model.AdminRequestModel;
import com.taslim.trainingmanagementsystem.model.UserRequestModel;
import com.taslim.trainingmanagementsystem.repository.AdminRepository;
import com.taslim.trainingmanagementsystem.service.AdminService;
import com.taslim.trainingmanagementsystem.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final UserService userService;

    @Override
    public ResponseEntity<Object> createAdmin(AdminRequestModel adminRequestModel) {

        AdminEntity adminExistedAlready = adminRepository.findByEmail(adminRequestModel.getEmail());
        if (Objects.nonNull(adminExistedAlready)) {
            throw new UserAlreadyExistException("This Email Already Existed");
        }

        AdminEntity admin = AdminEntity.builder()
                .fullName(adminRequestModel.getFullName())
                .profilePicture(adminRequestModel.getProfilePicture())
                .email(adminRequestModel.getEmail())
                .build();
        AdminEntity savedAdmin = adminRepository.save(admin);

        UserRequestModel model = UserRequestModel.builder()
                .email(adminRequestModel.getEmail())
                .name(adminRequestModel.getFullName())
                .role(Role.ADMIN.name())
                .password(adminRequestModel.getPassword())
                .build();

        ResponseEntity<Object> register = userService.register(model);
        if (register.getStatusCode()== HttpStatus.CREATED){
            log.info("Successfully registered");
        }

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
            AdminEntity admin = adminOptional.get();
            admin.setActive(Boolean.FALSE);
            adminRepository.save(admin);
            return ResponseEntity.ok("Admin with ID: " + id + " has been deleted.");
        } else {
            throw new AdminNotFoundException("Admin not found with ID: " + id);
        }
    }
}
