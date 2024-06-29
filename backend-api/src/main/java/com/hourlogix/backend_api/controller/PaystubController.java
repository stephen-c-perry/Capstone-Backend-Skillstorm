package com.hourlogix.backend_api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.hourlogix.backend_api.dto.PaystubDTO;
import com.hourlogix.backend_api.exceptions.ForbiddenException;
import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.model.PaystubSelectView;
import com.hourlogix.backend_api.model.PaystubView;
import com.hourlogix.backend_api.repository.PaystubRepo;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/hourlogix/employee/paystub")

public class PaystubController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final PaystubRepo paystubRepo;

    public PaystubController(PaystubRepo paystubRepo) {
        this.paystubRepo = paystubRepo;
    }

    @GetMapping("/{id}")
    public PaystubView getPaystub(@PathVariable Long id, @AuthenticationPrincipal Employee employee) {
        PaystubView result = paystubRepo.getByPaystubId(id);
        logger.debug(result.toString());
        if (result.getEmpId() != employee.getEmployeeId()) {
            logger.debug("ForbiddenException due to employee " + employee.getEmployeeId() + " trying to access paystub#" + result.getPaystubId() + " which belongs to employee " + result.getEmpId());
            throw new ForbiddenException("You do not have permission to view paystubs of other employees");
        }
        
        return result;
    }

    @GetMapping()
    public List<PaystubSelectView> getPaystubSelectView(@AuthenticationPrincipal Employee employee) {
        List<PaystubSelectView> result = paystubRepo.getAllPaystubsSelectView(employee.getEmployeeId());
        logger.debug(result.toString());
        return result;
    }

}
