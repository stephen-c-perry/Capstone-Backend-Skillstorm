package com.hourlogix.backend_api.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class LogHoursDTO {

    // changed from type Employee to Long 
    private Long employeeId;
    private LocalDate startDate;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private LocalDate endDate;

    //getters and setters
    public Long getEmployeeID() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    public LocalTime getTimeIn() {
        return timeIn;
    }
    public void setTimeIn(LocalTime timeIn) {
        this.timeIn = timeIn;
    }
    public LocalTime getTimeOut() {
        return timeOut;
    }
    public void setTimeOut(LocalTime timeOut) {
        this.timeOut = timeOut;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    @Override
    public String toString() {
        return "LogHoursDTO [employeeId=" + employeeId + ", startDate=" + startDate + ", timeIn=" + timeIn
                + ", timeOut=" + timeOut + ", endDate=" + endDate + "]";
    }

}
