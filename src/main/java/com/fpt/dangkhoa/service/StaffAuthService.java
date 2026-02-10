package com.fpt.dangkhoa.service;

import com.fpt.dangkhoa.dto.LoginRequest;
import com.fpt.dangkhoa.entity.Staff;
import com.fpt.dangkhoa.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StaffAuthService {

    private final StaffRepository staffRepository;

    public Staff login(LoginRequest request) {

        Staff staff = staffRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Email not found"));

        if (!staff.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return staff;
    }
}
