package com.centralibrary.librarymanager.controller;

import com.centralibrary.librarymanager.dto.LoginRequest;
import com.centralibrary.librarymanager.filter.TokenUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SecurityController {

    @Autowired
    TokenUtil tokenUtil;

    @PostMapping("/token")
    Map<String, String> generateToken(@Valid @RequestBody LoginRequest loginRequest) {
        String token = tokenUtil.generateToken(loginRequest.getEmailAddress());
        Map<String, String> response = new HashMap<>();
        response.put("accessToken", token);
        return response;
    }
}
