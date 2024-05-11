package com.centralibrary.librarymanager.controller;

import com.centralibrary.librarymanager.dto.CreateStaffRequest;
import com.centralibrary.librarymanager.entity.Staff;
import com.centralibrary.librarymanager.service.StaffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaffController {

    @Autowired
    StaffService staffService;

    @PostMapping("/staffs")
    Staff createStaff(@Valid @RequestBody CreateStaffRequest createStaffRequest) {
        return staffService.createStaff(createStaffRequest);
    }
}
