package com.hourlogix.backend_api.service;

import com.hourlogix.backend_api.dto.LoginDTO;
import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public Optional<LoginDTO> getEmployeeByUsername(String username) {
        Optional<Employee> employeeOptional = employeeRepository.findByUsername(username);
        return employeeOptional.map(this::convertToDTO);
    }

    private LoginDTO convertToDTO(Employee employee) {
        LoginDTO dto = new LoginDTO();
        dto.setEmployeeId(employee.getEmployeeId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());

        dto.setUsername(employee.getUsername());
        dto.setRole(employee.getRole());

        return dto;
    }
    
}
