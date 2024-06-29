package com.hourlogix.backend_api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PaystubSelectView {

    public Long getPaystubId();

    public void setPaystubId();

    public LocalDateTime getPayDate();

    public void setPayDate(LocalDateTime payDate) ;

    public LocalDateTime getBeginDate();
    
    public void setBeginDate(LocalDateTime beginDate) ;

    public LocalDateTime getEndDate();

    public void setEndDate(LocalDateTime endDate) ;

    public BigDecimal getCheckAmount();

    public void setCheckAmount(BigDecimal checkAmount);
    
    // @Override
    // public default String toString() {
    //     return getPayDate() + " " + getBeginDate() + " " + getEndDate() + " " + getCheckAmount();
    // }
}
