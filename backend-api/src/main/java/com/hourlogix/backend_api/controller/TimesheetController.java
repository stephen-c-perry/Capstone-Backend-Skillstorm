package com.hourlogix.backend_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hourlogix.backend_api.dto.TimesheetDTO;
import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.model.Timesheet;
import com.hourlogix.backend_api.service.TimesheetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hourlogix/employee/timesheets")
public class TimesheetController {

    private final TimesheetService timesheetService;

    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimesheetDTO> getTimesheetById(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        TimesheetDTO timesheet = timesheetService.getTimesheetById(id, userDetails);
        return ResponseEntity.ok(timesheet);
    }

    @GetMapping
    public ResponseEntity<List<TimesheetDTO>> getAllTimesheets(@AuthenticationPrincipal UserDetails userDetails) {
        List<TimesheetDTO> timesheets = timesheetService.getAllTimesheets(userDetails);
        return ResponseEntity.ok(timesheets);
    }

}
