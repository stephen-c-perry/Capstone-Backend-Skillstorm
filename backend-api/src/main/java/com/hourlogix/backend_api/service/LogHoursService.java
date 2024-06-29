package com.hourlogix.backend_api.service;

import com.hourlogix.backend_api.dto.LogHoursDTO;
import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.model.Timesheet;
import com.hourlogix.backend_api.repository.EmployeeRepository;
import com.hourlogix.backend_api.repository.TimesheetRepository;

import java.time.LocalDate;
import java.util.NoSuchElementException;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

@Service
public class LogHoursService {

    private final TimesheetRepository timesheetRepo;
    private EmployeeRepository employeeRepo;

    public LogHoursService(TimesheetRepository timesheetRepo, EmployeeRepository employeeRepo) {
        this.timesheetRepo = timesheetRepo;
        this.employeeRepo = employeeRepo;
    }

    public Timesheet saveLoggedHours(LogHoursDTO logHoursDTO) {
        // Don't save if employee doesn't exist
        Employee employee = employeeRepo.findById(logHoursDTO.getEmployeeID()).orElse(null);
        if (employee == null) 
            throw new NoSuchElementException("Cannot create timesheet for employee. Employee id " + logHoursDTO.getEmployeeID() + " does not exist");

        Timesheet timesheet = new Timesheet();

        timesheet.setEmployee(employee);
        timesheet.setStartDate(logHoursDTO.getStartDate());
        timesheet.setTimeIn(logHoursDTO.getTimeIn());
        timesheet.setTimeOut(logHoursDTO.getTimeOut());
        timesheet.setEndDate(logHoursDTO.getEndDate());
        timesheet.setStatus("Pending");

        return timesheetRepo.save(timesheet);
    }
}

