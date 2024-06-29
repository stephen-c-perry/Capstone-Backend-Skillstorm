package com.hourlogix.backend_api.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.hourlogix.backend_api.model.PaystubView;

// This DTO is not being used. 
// Instead the PaystubView is being used as a spring data jpa custom projection
public class PaystubDTO implements PaystubView {

    private Long paystubId;
    private Long empId;
    private Long ssnLast4;
    private String firstName;
    private String lastName;
    private LocalDateTime beginDate;
    private LocalDateTime endDate;
    private Double numHours;
    private BigDecimal hourlyWage; 
    private BigDecimal checkAmt;
    private Double taxRate; //flat tax for MVP, add tax API in second sprint
    private BigDecimal grossPeriod;
    private BigDecimal deductPeriod;  //total of all taxes and witholdings
    private BigDecimal netPeriod;
    // private BigDecimal ytdGross; // add later in either repo or service, try repo first
    // private BigDecimal ytdDeduct; 
    // private BigDecimal ytdNet; 
    
    //getters and setters
    public Long getPaystubId() {
        return paystubId;
    }
    public void setPaystubId(Long paystubId) {
        this.paystubId = paystubId;
    }
    public Long getEmpId() {
        return empId;
    }
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
    public Long getSsnLast4() {
        return ssnLast4;
    }
    public void setSsnLast4(Long ssnLast4) {
        this.ssnLast4 = ssnLast4;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public Double getNumHours() {
        return numHours;
    }
    public void setNumHours(Double numHours) {
        this.numHours = numHours;
    }
    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }
    public void setHourlyWage(BigDecimal hourlyWage) {
        this.hourlyWage = hourlyWage;
    }
    public BigDecimal getCheckAmt() {
        return checkAmt;
    }
    public void setCheckAmt(BigDecimal checkAmt) {
        this.checkAmt = checkAmt;
    }
    public Double getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
    public BigDecimal getGrossPeriod() {
        return grossPeriod;
    }
    public void setGrossPeriod(BigDecimal grossPeriod) {
        this.grossPeriod = grossPeriod;
    }
    public BigDecimal getDeductPeriod() {
        return deductPeriod;
    }
    public void setDeductPeriod(BigDecimal deductPeriod) {
        this.deductPeriod = deductPeriod;
    }
    public BigDecimal getNetPeriod() {
        return netPeriod;
    }
    public void setNetPeriod(BigDecimal netPeriod) {
        this.netPeriod = netPeriod;
    }
    // public BigDecimal getYtdGross() {
    //     return ytdGross;
    // }
    // public void setYtdGross(BigDecimal ytdGross) {
    //     this.ytdGross = ytdGross;
    // }
    // public BigDecimal getYtdDeduct() {
    //     return ytdDeduct;
    // }
    // public void setYtdDeduct(BigDecimal ytdDeduct) {
    //     this.ytdDeduct = ytdDeduct;
    // }
    // public BigDecimal getYtdNet() {
    //     return ytdNet;
    // }
    // public void setYtdNet(BigDecimal ytdNet) {
    //     this.ytdNet = ytdNet;
    // }
    
    public PaystubDTO(Long paystubId, Long empId, Long ssnLast4, String firstName, String lastName, LocalDateTime beginDate,
            LocalDateTime endDate, Double numHours, BigDecimal hourlyWage, BigDecimal checkAmt, Double taxRate, BigDecimal grossPeriod,
            BigDecimal deductPeriod, BigDecimal netPeriod, BigDecimal ytdGross, BigDecimal ytdDeduct, BigDecimal ytdNet) {
        this.paystubId = paystubId;
        this.empId = empId;
        this.ssnLast4 = ssnLast4;
        this.firstName = firstName;
        this.lastName = lastName;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.numHours = numHours;
        this.hourlyWage = hourlyWage;
        this.checkAmt = checkAmt;
        this.taxRate = taxRate;
        this.grossPeriod = grossPeriod;
        this.deductPeriod = deductPeriod;
        this.netPeriod = netPeriod;
        // this.ytdGross = ytdGross;
        // this.ytdDeduct = ytdDeduct;
        // this.ytdNet = ytdNet;
        
    }
    @Override
    public String toString() {
        return "PaystubDTO [paystubId=" + paystubId + ", empId=" + empId + ", ssnLast4=" + ssnLast4 + ", firstName="
                + firstName + ", lastName=" + lastName + ", beginDate=" + beginDate + ", endDate=" + endDate
                + ", numHours=" + numHours + ", hourlyWage=" + hourlyWage + ", checkAmt=" + checkAmt + ", taxRate="
                + taxRate + ", grossPeriod=" + grossPeriod + ", deductPeriod=" + deductPeriod + ", netPeriod="
                + netPeriod + "]";
    }


    

    
}
