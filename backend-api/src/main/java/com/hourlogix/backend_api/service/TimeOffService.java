package com.hourlogix.backend_api.service;

import com.hourlogix.backend_api.dto.TimeOffDTO;
import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.model.LeaveRequest;
import com.hourlogix.backend_api.repository.TimeOffRepository;
import com.hourlogix.backend_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeOffService {

    private final TimeOffRepository timeOffRepository;
    private final EmployeeRepository employeeRepository;

    public TimeOffService(TimeOffRepository timeOffRepository, EmployeeRepository employeeRepository) {
        this.timeOffRepository = timeOffRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<TimeOffDTO> getAllTimeOffRequests(Employee employee) {
        // filter by employee
        return timeOffRepository.findByEmployee(employee).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public TimeOffDTO submitTimeOffRequest(TimeOffDTO timeOffDTO) {
        LeaveRequest leaveRequest = new LeaveRequest();
        leaveRequest.setEmployee(employeeRepository.findById(timeOffDTO.getEmployeeId()).orElseThrow(() -> new RuntimeException("Employee not found")));
        leaveRequest.setReason(timeOffDTO.getReason());
        leaveRequest.setHoursOfLvRequested(timeOffDTO.getHoursOfLvRequested());
        leaveRequest.setTypeofLv(timeOffDTO.getTypeofLv());
        leaveRequest.setLvStartDate(timeOffDTO.getLvStartDate());
        leaveRequest.setLvEndDate(timeOffDTO.getLvEndDate());
        leaveRequest.setStatus("Pending");

        LeaveRequest savedLeaveRequest = timeOffRepository.save(leaveRequest);
        return convertToDTO(savedLeaveRequest);
    }

    private TimeOffDTO convertToDTO(LeaveRequest leaveRequest) {
        TimeOffDTO dto = new TimeOffDTO();
        dto.setEmployeeId(leaveRequest.getEmployee().getEmployeeId());
        dto.setFirstName(leaveRequest.getEmployee().getFirstName());
        dto.setLastName(leaveRequest.getEmployee().getLastName());
        dto.setEmail(leaveRequest.getEmployee().getEmail());
        dto.setReason(leaveRequest.getReason());
        dto.setHoursOfLvRequested(leaveRequest.getHoursOfLvRequested());
        dto.setTypeofLv(leaveRequest.getTypeofLv());
        dto.setLvStartDate(leaveRequest.getLvStartDate());
        dto.setLvEndDate(leaveRequest.getLvEndDate());
        dto.setStatus(leaveRequest.getStatus());
        return dto;
    }
}
