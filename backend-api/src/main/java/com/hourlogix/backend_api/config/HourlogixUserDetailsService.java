package com.hourlogix.backend_api.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.repository.EmployeeRepository;

@Service
public class HourlogixUserDetailsService implements UserDetailsService {
    private final EmployeeRepository employeeRepository;

    public HourlogixUserDetailsService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Employee employee = employeeRepository.findByUsername(username).orElseThrow(() -> {
            throw new UsernameNotFoundException(username + " not found");
        });
              

        return employee;
    }
}
