package com.hourlogix.backend_api.service;

import java.util.List;

import com.hourlogix.backend_api.dto.TimesheetDTO;

// These methods are made available to managers who view and approve timesheets
public interface TimekeepService {
    TimesheetDTO getTimesheetById(Long id);
    List<TimesheetDTO> getAllTimesheets();
    TimesheetDTO updateTimesheet(Long id, TimesheetDTO timesheet);
    void deleteTimesheet(Long id);
}
