package com.centralibrary.librarymanager.service;

import com.centralibrary.librarymanager.dto.CreateStaffRequest;
import com.centralibrary.librarymanager.dto.StaffRole;
import com.centralibrary.librarymanager.entity.Staff;
import com.centralibrary.librarymanager.repo.StaffRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StaffServiceTest {

    @Mock
    StaffRepository staffRepository;

    @InjectMocks
    StaffService staffService;

//    @Spy
//    Staff staff;

    @Test
    void createStaff_Success() {
        CreateStaffRequest createStaffRequest = new CreateStaffRequest();
        createStaffRequest.setStaffRole(StaffRole.ADMIN);
        createStaffRequest.setName("Durai");
        createStaffRequest.setPassword("password");
        createStaffRequest.setEmailAddress("email@address");

        staffService.createStaff(createStaffRequest);
        verify(staffRepository, times(1)).save(any());
    }

    @Test
    void createStaff_IT_ADMIN_NOT_SAVED() {
        CreateStaffRequest createStaffRequest = new CreateStaffRequest();
        createStaffRequest.setStaffRole(StaffRole.IT_SUPPORT);
        createStaffRequest.setName("Durai");
        createStaffRequest.setPassword("password");
        createStaffRequest.setEmailAddress("email@address");

        staffService.createStaff(createStaffRequest);
        verify(staffRepository, times(0)).save(any());
//        assertTrue(staff.getRole().equals(StaffRole.IT_SUPPORT));
    }


}