package com.hourlogix.backend_api.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "paystub")
public class Paystub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paystubId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "period_beginning", nullable = false)
    private LocalDateTime beginDate;

    @Column(name = "period_ending", nullable = false)
    private LocalDateTime endDate;

    @Column(name = "hours_worked")
    private BigDecimal numHours;

    @Column(name = "check_total")
    private BigDecimal checkAmt;

    public Paystub() {
    }

    public Paystub(LocalDateTime payDate) {
        this.payDate = payDate;
    }

    private LocalDateTime payDate;

    public Paystub(Long paystubId, Employee employee, LocalDateTime beginDate, LocalDateTime endDate, LocalDateTime payDate, BigDecimal numHours) {
        this.paystubId = paystubId;
        this.employee = employee;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.payDate = payDate;
        this.numHours = numHours;
        
    }

    public Long getPaystubId() {
        return paystubId;
    }

    public void setPaystubId(Long paystubId) {
        this.paystubId = paystubId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee empId) {
        this.employee = empId;
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

    public BigDecimal getNumHours() {
        return numHours;
    }

    public void setNumHours(BigDecimal numHours) {
        this.numHours = numHours;
    }

    public BigDecimal getCheckAmt() {
        return checkAmt;
    }

    public void setCheckAmt(BigDecimal checkAmt) {
        this.checkAmt = checkAmt;
    }

    @Override
    public String toString() {
        return "Paystub [paystubId=" + paystubId + ", employee=" + employee + ", beginDate=" + beginDate + ", endDate="
                + endDate + ", numHours=" + numHours + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((paystubId == null) ? 0 : paystubId.hashCode());
        result = prime * result + ((employee == null) ? 0 : employee.hashCode());
        result = prime * result + ((beginDate == null) ? 0 : beginDate.hashCode());
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((numHours == null) ? 0 : numHours.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Paystub other = (Paystub) obj;
        if (paystubId == null) {
            if (other.paystubId != null)
                return false;
        } else if (!paystubId.equals(other.paystubId))
            return false;
        if (employee == null) {
            if (other.employee != null)
                return false;
        } else if (!employee.equals(other.employee))
            return false;
        if (beginDate == null) {
            if (other.beginDate != null)
                return false;
        } else if (!beginDate.equals(other.beginDate))
            return false;
        if (endDate == null) {
            if (other.endDate != null)
                return false;
        } else if (!endDate.equals(other.endDate))
            return false;
        if (numHours == null) {
            if (other.numHours != null)
                return false;
        } else if (!numHours.equals(other.numHours))
            return false;
        return true;
    }

    public LocalDateTime getPayDate() {
        return payDate;
    }

    public void setPayDate(LocalDateTime payDate) {
        this.payDate = payDate;
    }

}
