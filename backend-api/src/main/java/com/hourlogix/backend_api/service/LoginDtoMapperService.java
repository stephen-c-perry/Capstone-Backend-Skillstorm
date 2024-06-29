package com.hourlogix.backend_api.service;

import org.springframework.stereotype.Service;

import com.hourlogix.backend_api.dto.LoginDTO;
import com.hourlogix.backend_api.model.Employee;

@Service
public class LoginDtoMapperService {

     public LoginDTO convertToLoginDTO(Employee employee) {
        if (employee == null) {
            return null;
        }

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setEmployeeId(employee.getEmployeeId());
        loginDTO.setFirstName(employee.getFirstName());
        loginDTO.setLastName(employee.getLastName());
        loginDTO.setUsername(employee.getUsername());
        loginDTO.setRole(employee.getRole());
        loginDTO.setPassword(employee.getPassword());

        return loginDTO;
    }

}
