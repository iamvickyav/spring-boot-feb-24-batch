package com.centralibrary.librarymanager.dto;

import jakarta.validation.constraints.*;

// javax.validation
public class CreateStaffRequest {

    @NotNull
    @NotEmpty
    private String name;
    private StaffRole staffRole;

    @NotNull
    @Email
    private String emailAddress;

    @NotNull
    @NotEmpty
    private String password;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StaffRole getStaffRole() {
        return staffRole;
    }

    public void setStaffRole(StaffRole staffRole) {
        this.staffRole = staffRole;
    }
}
