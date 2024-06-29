package com.hourlogix.backend_api.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;

@Entity
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveRequestId;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private String status;
    private Integer availableLv;
    private String reason;
    private Integer hoursOfLvRequested;
    private String typeofLv;
    private LocalDate lvStartDate;
    private LocalDate lvEndDate;
    
    public LeaveRequest() {
    }

    public Long getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(Long leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAvailableLv() {
        return availableLv;
    }

    public void setAvailableLv(Integer availableLv) {
        this.availableLv = availableLv;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getHoursOfLvRequested() {
        return hoursOfLvRequested;
    }

    public void setHoursOfLvRequested(Integer hoursOfLvRequested) {
        this.hoursOfLvRequested = hoursOfLvRequested;
    }

    public String getTypeofLv() {
        return typeofLv;
    }

    public void setTypeofLv(String typeofLv) {
        this.typeofLv = typeofLv;
    }

    public LocalDate getLvStartDate() {
        return lvStartDate;
    }

    public void setLvStartDate(LocalDate lvStartDate) {
        this.lvStartDate= lvStartDate;
    }

    public LocalDate getLvEndDate() {
        return lvEndDate;
    }

    public void setLvEndDate(LocalDate lvEndDate) {
        this.lvEndDate= lvEndDate;
    }

    @Override
    public String toString() {
        return "LeaveRequest [leaveRequestId=" + leaveRequestId + ", employee=" + employee + ", status=" + status
                + ", availableLv=" + availableLv + ", reason=" + reason + ", hoursOfLvRequested=" + hoursOfLvRequested
                + ", typeofLv=" + typeofLv + ", lvStartDate=" + lvStartDate+ ", lvEndDate=" + lvEndDate+ "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((leaveRequestId == null) ? 0 : leaveRequestId.hashCode());
        result = prime * result + ((employee == null) ? 0 : employee.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((availableLv == null) ? 0 : availableLv.hashCode());
        result = prime * result + ((reason == null) ? 0 : reason.hashCode());
        result = prime * result + ((hoursOfLvRequested == null) ? 0 : hoursOfLvRequested.hashCode());
        result = prime * result + ((typeofLv == null) ? 0 : typeofLv.hashCode());
        result = prime * result + ((lvStartDate== null) ? 0 : lvStartDate.hashCode());
        result = prime * result + ((lvEndDate== null) ? 0 : lvEndDate.hashCode());
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
        LeaveRequest other = (LeaveRequest) obj;
        if (leaveRequestId == null) {
            if (other.leaveRequestId != null)
                return false;
        } else if (!leaveRequestId.equals(other.leaveRequestId))
            return false;
        if (employee == null) {
            if (other.employee != null)
                return false;
        } else if (!employee.equals(other.employee))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (availableLv == null) {
            if (other.availableLv != null)
                return false;
        } else if (!availableLv.equals(other.availableLv))
            return false;
        if (reason == null) {
            if (other.reason != null)
                return false;
        } else if (!reason.equals(other.reason))
            return false;
        if (hoursOfLvRequested == null) {
            if (other.hoursOfLvRequested != null)
                return false;
        } else if (!hoursOfLvRequested.equals(other.hoursOfLvRequested))
            return false;
        if (typeofLv == null) {
            if (other.typeofLv != null)
                return false;
        } else if (!typeofLv.equals(other.typeofLv))
            return false;
        if (lvStartDate== null) {
            if (other.lvStartDate!= null)
                return false;
        } else if (!lvStartDate.equals(other.lvStartDate))
            return false;
        if (lvEndDate== null) {
            if (other.lvEndDate!= null)
                return false;
        } else if (!lvEndDate.equals(other.lvEndDate))
            return false;
        return true;
    }

   

    
    
}