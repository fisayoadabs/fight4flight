package io.group02.fight4flight.service;

import io.group02.fight4flight.model.Admin;
import io.group02.fight4flight.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    // Method to create or update an admin
    public Admin saveOrUpdateAdmin(Admin admin) {
        // Here, you might want to handle password encryption
        return adminRepository.save(admin);
    }

    // Method to get all admins
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Method to get an admin by ID
    public Optional<Admin> getAdminById(Long adminId) {
        return adminRepository.findById(adminId);
    }

    // Method to delete an admin
    public void deleteAdmin(Long adminId) {
        adminRepository.deleteById(adminId);
    }

    // Method to find an admin by username
    public Admin getAdminByUsername(String username) {
        return adminRepository.findByUsername(username);
    }

    // Additional methods as required
}
