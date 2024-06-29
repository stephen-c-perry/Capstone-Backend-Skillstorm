package com.hourlogix.backend_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import com.hourlogix.backend_api.model.PaystubSelectView;

// This DTO is not being used. 
// Instead the PaystubSelectView is being used as a spring data jpa custom projection
public class PaystubSelectViewDTO implements PaystubSelectView{
    
    private Long paystubId;
    private LocalDateTime payDate;
    private LocalDateTime beginDate; 
    private LocalDateTime endDate;
    private BigDecimal checkAmount;
    
    public LocalDateTime getPayDate() {
        return payDate;
    }
    public void setPayDate(LocalDateTime payDate) {
        this.payDate = payDate;
    }
    public LocalDateTime getBeginDate() {
        return beginDate;
    }
    public void setBeginDate(LocalDateTime beginDate) {
        this.beginDate = beginDate;
    }
    public LocalDateTime getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
    public BigDecimal getCheckAmount() {
        return checkAmount;
    }
    public void setCheckAmount(BigDecimal checkAmount) {
        this.checkAmount = checkAmount;
    }
   
    @Override
    public Long getPaystubId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPaystubId'");
    }
    @Override
    public void setPaystubId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPaystubId'");
    }
    @Override
    public String toString() {
        return "PaystubSelectViewDTO [paystubId=" + paystubId + ", payDate=" + payDate + ", beginDate=" + beginDate
                + ", endDate=" + endDate + ", checkAmount=" + checkAmount + "]";
    }

    



}
