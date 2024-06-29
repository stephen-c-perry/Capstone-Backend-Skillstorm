package com.hourlogix.backend_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.hourlogix.backend_api.dto.TimesheetDTO;
import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.model.Timesheet;
import com.hourlogix.backend_api.repository.TimesheetRepository;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    private TimesheetRepository timesheetrepository;

    private TimesheetMapperService mapper;

    public TimesheetServiceImpl(TimesheetRepository timesheetrepository, TimesheetMapperService mapper) {
        this.timesheetrepository = timesheetrepository;
        this.mapper = mapper;
    }

    @Override
    public TimesheetDTO getTimesheetById(Long id, UserDetails userdetails) {
        // Throws exception if doesn't exist
        Timesheet timesheet = timesheetrepository.findById(id).get();
        // Throws exception if timesheet does not belong to logged in user 
        if (!userdetails.getUsername()
                .equals(timesheet.getEmployee().getUsername())) {
            throw new InsufficientAuthenticationException("You do not have permission to access the Timesheet with id " + id);
        }
        // Else return dto
        TimesheetDTO dto = mapper.toDTO(timesheet);
        return dto;
    }

    @Override
    public List<TimesheetDTO> getAllTimesheets(UserDetails userDetails) {
        Employee employee = (Employee) userDetails;
        return timesheetrepository.findByEmployee(employee)
                        .stream()
                        .map(mapper::toDTO)
                        .collect(Collectors.toList());
    }


}



