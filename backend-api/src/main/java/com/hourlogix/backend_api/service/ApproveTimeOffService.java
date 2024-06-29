package com.hourlogix.backend_api.service;

import com.hourlogix.backend_api.dto.ApproveTimeDTO;
import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.model.LeaveRequest;
import com.hourlogix.backend_api.repository.ApproveTimeOffRepository;
import com.hourlogix.backend_api.repository.EmployeeRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class ApproveTimeOffService {

    private final ApproveTimeOffRepository approveTimeOffRepository;

    public ApproveTimeOffService(ApproveTimeOffRepository approveTimeOffRepository) {
        this.approveTimeOffRepository = approveTimeOffRepository;
    }

    public List<ApproveTimeDTO> getAllLeaveRequests() {
        return approveTimeOffRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public ApproveTimeDTO approveLeaveRequest(Long id) {
        LeaveRequest leaveRequest = approveTimeOffRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cannot approve leave request with id " + id + " does not exist"));
        leaveRequest.setStatus("Approved");

        return convertToDTO(approveTimeOffRepository.save(leaveRequest));
    }

    public void denyLeaveRequest(Long id) {
        LeaveRequest leaveRequest = approveTimeOffRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cannot deny leave request with id " + id + " does not exist"));
        leaveRequest.setStatus("Denied");

        convertToDTO(approveTimeOffRepository.save(leaveRequest));
    }

    public List<ApproveTimeDTO> getTimeOffRequestsByStatus(String status) {
        return approveTimeOffRepository.findByStatus(status).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }


    private ApproveTimeDTO convertToDTO(LeaveRequest leaveRequest) {
        ApproveTimeDTO dto = new ApproveTimeDTO();
        dto.setRequestId(leaveRequest.getLeaveRequestId());
        dto.setEmployeeId(leaveRequest.getEmployee().getEmployeeId());
        dto.setFirstName(leaveRequest.getEmployee().getFirstName());
        dto.setLastName(leaveRequest.getEmployee().getLastName());
        dto.setAvailableSickLv(leaveRequest.getEmployee().getAvailableSickLv());
        dto.setAvailableAnnualLv(leaveRequest.getEmployee().getAvailableAnnualLv());
        dto.setEmail(leaveRequest.getEmployee().getEmail());
        dto.setAvailableLv(leaveRequest.getAvailableLv()); 
        dto.setReason(leaveRequest.getReason());
        dto.setHoursOfLvRequested(leaveRequest.getHoursOfLvRequested());
        dto.setTypeofLv(leaveRequest.getTypeofLv());
        dto.setLvStartDate(leaveRequest.getLvStartDate());
        dto.setLvEndDate(leaveRequest.getLvEndDate());
        dto.setStatus(leaveRequest.getStatus());
        return dto;
    }
}
