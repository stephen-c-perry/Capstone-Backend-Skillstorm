package com.hourlogix.backend_api.controller;

import com.hourlogix.backend_api.dto.LoginDTO;
import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.repository.EmployeeRepository;
import com.hourlogix.backend_api.service.LoginDtoMapperService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

// @CrossOrigin
@RestController
// base URL for all endpoints in this controller
@RequestMapping("/api/v1/hourlogix")
public class SecurityController {

    // Declare dependencies
    private UserDetailsService userDetailsService;
    private LoginDtoMapperService mapper;

    // constructor injection
    public SecurityController(UserDetailsService service, LoginDtoMapperService mapper) {
        this.userDetailsService = service;
        this.mapper = mapper;
    }

    // server permits requests from other domains
    // @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@AuthenticationPrincipal Employee employee) {
        LoginDTO dto = mapper.convertToLoginDTO(employee);
        dto.setPassword(null);
        return ResponseEntity.ok(dto);
    }

    // Return the currently authenticated user
    @GetMapping("/me")
    public Principal getCurrentUser(Principal principal) {
        return principal;
    }
}
