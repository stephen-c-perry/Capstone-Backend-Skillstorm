package com.hourlogix.backend_api.dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;

public class TimeOffDTO {
    private Long employeeId;
    @NotNull(message = "Name cannot be null")
    private String firstName;
    @NotNull(message = "Name cannot be null")
    private String lastName;
    @Column(name = "Available Sick Leave")
    @Email(message = "Email should be valid")
    private String email;
    private String reason;
    // needs to be auto calculated
    private Integer hoursOfLvRequested;
    private Integer hoursPerDay;
    private String typeofLv;
    private LocalDate lvStartDate;
    private LocalDate lvEndDate;
    private String status;
    

    public TimeOffDTO() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public void setLvStartDate(LocalDate localDate) {
        this.lvStartDate = localDate;
    }

    public LocalDate getLvEndDate() {
        return lvEndDate;
    }

    public void setLvEndDate(LocalDate localDate) {
        this.lvEndDate = localDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TimeOffDTO [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", email=" + email + ", reason=" + reason + ", hoursOfLvRequested=" + hoursOfLvRequested
                + ", hoursPerDay=" + hoursPerDay + ", typeofLv=" + typeofLv + ", lvStartDate=" + lvStartDate
                + ", lvEndDate=" + lvEndDate + ", status=" + status + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((reason == null) ? 0 : reason.hashCode());
        result = prime * result + ((hoursOfLvRequested == null) ? 0 : hoursOfLvRequested.hashCode());
        result = prime * result + ((hoursPerDay == null) ? 0 : hoursPerDay.hashCode());
        result = prime * result + ((typeofLv == null) ? 0 : typeofLv.hashCode());
        result = prime * result + ((lvStartDate == null) ? 0 : lvStartDate.hashCode());
        result = prime * result + ((lvEndDate == null) ? 0 : lvEndDate.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
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
        TimeOffDTO other = (TimeOffDTO) obj;
        if (employeeId == null) {
            if (other.employeeId != null)
                return false;
        } else if (!employeeId.equals(other.employeeId))
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (lastName == null) {
            if (other.lastName != null)
                return false;
        } else if (!lastName.equals(other.lastName))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
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
        if (hoursPerDay == null) {
            if (other.hoursPerDay != null)
                return false;
        } else if (!hoursPerDay.equals(other.hoursPerDay))
            return false;
        if (typeofLv == null) {
            if (other.typeofLv != null)
                return false;
        } else if (!typeofLv.equals(other.typeofLv))
            return false;
        if (lvStartDate == null) {
            if (other.lvStartDate != null)
                return false;
        } else if (!lvStartDate.equals(other.lvStartDate))
            return false;
        if (lvEndDate == null) {
            if (other.lvEndDate != null)
                return false;
        } else if (!lvEndDate.equals(other.lvEndDate))
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        return true;
    }

    public Integer getHoursPerDay() {
        return hoursPerDay;
    }

    public void setHoursPerDay(Integer hoursPerDay) {
        this.hoursPerDay = hoursPerDay;
    }
    

    
}
