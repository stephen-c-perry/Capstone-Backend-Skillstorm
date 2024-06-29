package com.hourlogix.backend_api.controller;

import com.hourlogix.backend_api.dto.ApproveTimeDTO;
import com.hourlogix.backend_api.service.ApproveTimeOffService;
import org.springframework.web.bind.annotation.*;
// hasRole(“MANAGER”)
import java.util.List;

//allow frontend requests
// @CrossOrigin
@RestController
// base URL for all endpoints in this controller
@RequestMapping("api/v1/hourlogix/manager/approvetimeoff")
public class ApproveTimeOffController {

    // Dependency
    private final ApproveTimeOffService approveTimeOffService;

    public ApproveTimeOffController(ApproveTimeOffService approveTimeOffService) {
        this.approveTimeOffService = approveTimeOffService;
    }

    // @CrossOrigin
    @GetMapping
    public List<ApproveTimeDTO> getAllLeaveRequests() {
        return approveTimeOffService.getAllLeaveRequests();
    }

    // http://localhost:8080/hourlogix/manager/approvetimeoff
    // @CrossOrigin
    @GetMapping("/filter") // filtering
    public List<ApproveTimeDTO> getTimeOffRequestsByStatus(@RequestParam String status) {
        return approveTimeOffService.getTimeOffRequestsByStatus(status);
    }

    // http://localhost:8080/hourlogix/manager/approvetimeoff/filter?status=approved
    // @CrossOrigin
    @PutMapping("/approve/{id}")
    public ApproveTimeDTO approveLeaveRequest(@PathVariable Long requestId) {
        return approveTimeOffService.approveLeaveRequest(requestId);
    }

    // http://localhost:8080/hourlogix/manager/approvetimeoff/approve/101
    // @CrossOrigin
    @PutMapping("/deny/{id}")
    public void denyLeaveRequest(@PathVariable Long id) {
        approveTimeOffService.denyLeaveRequest(id);
    }
    // http://localhost:8080/hourlogix/manager/approvetimeoff/deny/101
}
