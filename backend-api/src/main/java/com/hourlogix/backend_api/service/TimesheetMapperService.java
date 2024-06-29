package com.hourlogix.backend_api.service;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

import com.hourlogix.backend_api.dto.TimesheetDTO;
import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.model.Timesheet;
import com.hourlogix.backend_api.repository.EmployeeRepository;

@Service
public class TimesheetMapperService {

    private EmployeeRepository employeeRepository;

    public TimesheetMapperService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public TimesheetDTO toDTO(Timesheet timesheet) {
        if (timesheet == null) {
            return null;
        }

        TimesheetDTO dto = new TimesheetDTO();
        dto.setEmployee_id(timesheet.getEmployee().getEmployeeId());
        dto.setEmp_name(timesheet.getEmployee().getFirstName() + " " + timesheet.getEmployee().getLastName());
        dto.setCreated_date(timesheet.getCreatedDate().toString()); // LocalDate toString() provides ISO-8601 format
        dto.setStart_date(timesheet.getStartDate().toString());
        dto.setEnd_date(timesheet.getEndDate().toString());
        dto.setTime_in(timesheet.getTimeIn().toString()); // LocalTime toString() provides ISO-8601 format
        dto.setTime_out(timesheet.getTimeOut().toString());
        //dto.setStatus(timesheet.getStatus());
        
        // Calculate total time
        long diffInMinutes = timesheet.getTimeIn().until(timesheet.getTimeOut(), java.time.temporal.ChronoUnit.MINUTES);
        long hours = diffInMinutes / 60;
        long minutes = diffInMinutes % 60;
        dto.setTotal_time(String.format("%02d:%02d", hours, minutes));

        return dto;
    }

    public Timesheet toEntity(TimesheetDTO dto) {
        if (dto == null) {
            return null;
        }
        
        // Don't create timesheet for non-existent employee
        Employee employee = employeeRepository.findById(dto.getEmployee_id()).orElse(null);
        if (employee == null) {
            return null;
        }

        Timesheet timesheet = new Timesheet();
        timesheet.setEmployee(employee);
        timesheet.setStartDate(LocalDate.parse(dto.getStart_date())); // Parse String to LocalDate
        timesheet.setEndDate(LocalDate.parse(dto.getEnd_date()));
        timesheet.setCreatedDate(LocalDate.parse(dto.getCreated_date()));
        timesheet.setTimeIn(LocalTime.parse(dto.getTime_in())); // Parse String to LocalTime
        timesheet.setTimeOut(LocalTime.parse(dto.getTime_out()));
        timesheet.setStatus(dto.getStatus());

        return timesheet;
    }

}
