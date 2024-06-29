package com.hourlogix.backend_api.controller;



import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.hourlogix.backend_api.dto.LogHoursDTO;
import com.hourlogix.backend_api.exceptions.ForbiddenException;
import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.model.Timesheet;
import com.hourlogix.backend_api.service.LogHoursService;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping("/api/v1/hourlogix/employee")
public class LogHoursController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private LogHoursService logHoursService;

    public LogHoursController(LogHoursService logHoursService) {
        this.logHoursService = logHoursService;
    }

    @PostMapping("/loghours")
    public ResponseEntity<URI> logHours(@RequestBody LogHoursDTO logHoursDTO, @AuthenticationPrincipal UserDetails userDetails, UriComponentsBuilder ucb) {
        logger.debug("========\nPOST /loghours received DTO " + logHoursDTO.toString());
        Long employeeId = ((Employee) userDetails).getEmployeeId();
        if (logHoursDTO.getEmployeeID() != employeeId) {
            throw new ForbiddenException("You do not have permission to log hours for " + logHoursDTO.getEmployeeID() + ". Your employee id is " + employeeId);
        }
        Timesheet timesheet = logHoursService.saveLoggedHours(logHoursDTO);
        URI locationOfNewTimesheet = ucb
                .path("api/v1/hourlogix/employee/timesheets/{id}")
                .buildAndExpand(timesheet.getEmployee().getEmployeeId())
                .toUri();
        return ResponseEntity.created(locationOfNewTimesheet).build();
    }

}
