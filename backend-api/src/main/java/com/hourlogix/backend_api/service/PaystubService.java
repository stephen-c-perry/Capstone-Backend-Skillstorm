package com.hourlogix.backend_api.service;

import com.hourlogix.backend_api.model.Paystub;
import com.hourlogix.backend_api.model.PaystubSelectView;
import com.hourlogix.backend_api.repository.PaystubRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// This class is not being used.
// Instead the PaystubRepo is being injected directly into the PaystubController.
// Note, the logic here was no longer needed when a cutom query was used to convert
// the entity to a custom projection PaystubView.
@Service
public class PaystubService {

    @Autowired
    private PaystubRepo paystubRepo;

    public Paystub getPaystubById(Long paystubId) {
        Optional<Paystub> paystubOpt = paystubRepo.findById(paystubId);
        return paystubOpt.orElse(null);
    }

    public List<PaystubSelectView> getAllPaystubsSelectView() {
        return paystubRepo.getAllPaystubsSelectView(null);
    }

    // public PaystubDTO convertToDTO(PaystubDTO entity, PaystubDTO paystubDetails) {
    //     entity.setEmpId(paystubDetails.getEmpId());
    //     entity.setSsnLast4(paystubDetails.getSsnLast4());
    //     entity.setFirstName(paystubDetails.getFirstName());
    //     entity.setLastName(paystubDetails.getLastName());
    //     entity.setBeginDate(paystubDetails.getBeginDate());
    //     entity.setEndDate(paystubDetails.getEndDate());
    //     entity.setNumHours(paystubDetails.getNumHours());
    //     entity.setHourlyWage(paystubDetails.getHourlyWage());
    //     entity.setCheckAmt(paystubDetails.getCheckAmt());
    //     entity.setTaxRate(paystubDetails.getTaxRate());
    //     entity.setGrossPeriod(paystubDetails.getGrossPeriod());
    //     entity.setDeductPeriod(paystubDetails.getDeductPeriod());
    //     entity.setNetPeriod(paystubDetails.getNetPeriod());
    //     // entity.setYtdGross(paystubDetails.getYtdGross());
    //     // entity.setYtdDeduct(paystubDetails.getYtdDeduct());
    //     // entity.setYtdNet(paystubDetails.getYtdNet());
    //     return entity;
    // }

    
    }

