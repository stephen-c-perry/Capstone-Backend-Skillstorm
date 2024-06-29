package com.hourlogix.backend_api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface PaystubView {

    public Long getPaystubId();

    public Long getEmpId();

    public Long getSsnLast4();

    public String getFirstName();

    public String getLastName();

    public LocalDateTime getBeginDate();

    public LocalDateTime getEndDate();

    public Double getNumHours();

    public BigDecimal getHourlyWage();

    public BigDecimal getCheckAmt();

    public Double getTaxRate();

    public BigDecimal getGrossPeriod();

    public BigDecimal getDeductPeriod();

    public BigDecimal getNetPeriod();

}
