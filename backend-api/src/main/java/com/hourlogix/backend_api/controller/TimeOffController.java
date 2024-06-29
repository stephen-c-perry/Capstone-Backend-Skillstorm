package com.hourlogix.backend_api.controller;

import com.hourlogix.backend_api.dto.TimeOffDTO;
import com.hourlogix.backend_api.exceptions.ForbiddenException;
import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.service.TimeOffService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
// base URL for all endpoints in this controller
@RequestMapping("api/v1/hourlogix/employee/requesttimeoff")
public class TimeOffController {

    // Dependency
    private final TimeOffService timeOffService;

    public TimeOffController(TimeOffService timeOffService) {
        this.timeOffService = timeOffService;
    }

    @GetMapping
    public List<TimeOffDTO> getAllTimeOffRequests(@AuthenticationPrincipal Employee employee) {
        // filter by the person logged in
        return timeOffService.getAllTimeOffRequests(employee);
    }

    @PostMapping
    public ResponseEntity<TimeOffDTO> submitTimeOffRequest(@RequestBody TimeOffDTO timeOffDTO, @AuthenticationPrincipal Employee employee) {
        // check the person in the dto matches the person logged in
        if (employee.getEmployeeId() != timeOffDTO.getEmployeeId()) {
            throw new ForbiddenException("You do not have permission to create a timeoff request for " + timeOffDTO.getFirstName() + " " + timeOffDTO.getLastName());
        }
        return new ResponseEntity<>(timeOffService.submitTimeOffRequest(timeOffDTO), HttpStatus.CREATED);
    }

    
}
