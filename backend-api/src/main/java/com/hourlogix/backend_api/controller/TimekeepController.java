package com.hourlogix.backend_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hourlogix.backend_api.dto.TimesheetDTO;
import com.hourlogix.backend_api.service.TimekeepService;

@RestController
@RequestMapping("api/v1/hourlogix/manager/timekeeps")
public class TimekeepController {

    private TimekeepService timekeepService;

    public TimekeepController(TimekeepService timekeepService) {
        this.timekeepService = timekeepService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TimesheetDTO> getTimesheetById(@PathVariable Long id) {
        TimesheetDTO timesheet = timekeepService.getTimesheetById(id);
        return ResponseEntity.ok(timesheet);
    }

    @GetMapping
    public ResponseEntity<List<TimesheetDTO>> getAllTimesheets() {
        List<TimesheetDTO> timesheets = timekeepService.getAllTimesheets();
        return ResponseEntity.ok(timesheets);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TimesheetDTO> updateTimesheet(@PathVariable Long id, @RequestBody TimesheetDTO timesheet) {
        TimesheetDTO updatedTimesheet = timekeepService.updateTimesheet(id, timesheet);
        if (updatedTimesheet != null) {
            return ResponseEntity.ok(updatedTimesheet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteTimesheet(@PathVariable Long id) {
        timekeepService.deleteTimesheet(id);
        return ResponseEntity.noContent().build();
    }
}
