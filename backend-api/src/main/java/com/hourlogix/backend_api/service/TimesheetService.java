package com.hourlogix.backend_api.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.hourlogix.backend_api.dto.TimesheetDTO;

import java.util.List;

/**
 * Interface TimesheetService contains the methods employees may use to view their timesheets.
 */
public interface TimesheetService {
    TimesheetDTO getTimesheetById(Long id, UserDetails userDetails);
    List<TimesheetDTO> getAllTimesheets(UserDetails userDetails);
}
