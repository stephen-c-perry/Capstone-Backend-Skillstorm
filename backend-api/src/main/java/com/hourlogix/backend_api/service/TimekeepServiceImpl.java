package com.hourlogix.backend_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.hourlogix.backend_api.dto.TimesheetDTO;
import com.hourlogix.backend_api.model.Timesheet;
import com.hourlogix.backend_api.repository.TimesheetRepository;

// Used by TimekeepController to handle managers viewing and approving timesheets.
@Service
public class TimekeepServiceImpl implements TimekeepService {

    private  TimesheetRepository timesheetRepo;

    private TimesheetMapperService mapper;

    public TimekeepServiceImpl(TimesheetRepository timesheetRepo, TimesheetMapperService mapper) {
        this.timesheetRepo = timesheetRepo;
        this.mapper = mapper;
    }

    @Override
    public TimesheetDTO getTimesheetById(Long id) {
        Timesheet timesheet = timesheetRepo.findById(id).orElse(null);
        TimesheetDTO dto = mapper.toDTO(timesheet);
        return dto;
    }

    @Override
    public List<TimesheetDTO> getAllTimesheets() {
        return timesheetRepo.findAll().stream()
                            .map(mapper::toDTO)
                            .collect(Collectors.toList());
    }

    @Override
    public TimesheetDTO updateTimesheet(Long id, TimesheetDTO dto) {
        if (timesheetRepo.existsById(id)) { // if exists, save update
            // convert dto to entity
            Timesheet timesheet = mapper.toEntity(dto);
            // make sure to set timesheet id before calling save
            timesheet.setId(id);
            timesheet = timesheetRepo.save(timesheet);
            // convert entity to dto
            return mapper.toDTO(timesheet);
        } // else doesn't exist so return null
        return null;
    }

    @Override
    public void deleteTimesheet(Long id) {
        timesheetRepo.deleteById(id);
    }


}
 