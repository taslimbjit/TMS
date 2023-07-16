package com.taslim.onlinelibrary.service;

import com.taslim.onlinelibrary.entity.AdminEntity;
import com.taslim.onlinelibrary.model.AdminRequestModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {
    ResponseEntity<Object> createAdmin(AdminRequestModel adminRequestModel);
    List<AdminEntity> getAllAdmins();
    ResponseEntity<Object> getAdminById(Long id);
    ResponseEntity<Object> updateAdmin(Long id, AdminRequestModel adminRequestModel);
    ResponseEntity<Object> deleteAdmin(Long id);
}
