package com.centralibrary.librarymanager.service;

import com.centralibrary.librarymanager.aop.TrackExecutionTime;
import com.centralibrary.librarymanager.dto.CreateStaffRequest;
import com.centralibrary.librarymanager.dto.LoginRequest;
import com.centralibrary.librarymanager.dto.StaffRole;
import com.centralibrary.librarymanager.entity.Staff;
import com.centralibrary.librarymanager.repo.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StaffService {

    @Autowired
    StaffRepository staffRepository;

    @TrackExecutionTime
    public Staff createStaff(CreateStaffRequest createStaffRequest) {
       return saveStaff(createStaffRequest);
    }

    public Boolean validateStaff(LoginRequest loginRequest) {
        Staff staff = staffRepository.findByEmailAddress(loginRequest.getEmailAddress());
        if(staff.getPassword().equals(loginRequest.getPassword())) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    private Staff saveStaff(CreateStaffRequest createStaffRequest) {
        Staff staff = new Staff();
        staff.setName(createStaffRequest.getName());
        staff.setRole(createStaffRequest.getStaffRole());
        staff.setPassword(createStaffRequest.getPassword());
        staff.setEmailAddress(createStaffRequest.getEmailAddress());

        if(staff.getRole() != StaffRole.IT_SUPPORT) {
            staff = staffRepository.save(staff);
        }
        return staff;
    }
}
