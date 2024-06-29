package com.hourlogix.backend_api.dto;

import java.time.LocalDate;
import java.util.Date;

import jakarta.validation.constraints.*;

public class ApproveTimeDTO {

    private Long employeeId;

    private Long requestId;

    @NotNull(message = "Name cannot be null")
    private String firstName;

    @NotNull(message = "Name cannot be null")
    private String lastName;

    private Integer availableSickLv;

    private Integer availableAnnualLv;

    @Email(message = "Email should be valid")
    private String email;

    private Integer availableLv;
    private String reason;
    private Integer hoursOfLvRequested;
    private String typeofLv;
    private LocalDate lvStartDate;
    private LocalDate lvEndDate;
    private String status;
    
    public ApproveTimeDTO() {
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

    public Integer getAvailableSickLv() {
        return availableSickLv;
    }

    public void setAvailableSickLv(Integer availableSickLv) {
        this.availableSickLv = availableSickLv;
    }

    public Integer getAvailableAnnualLv() {
        return availableAnnualLv;
    }

    public void setAvailableAnnualLv(Integer availableAnnualLv) {
        this.availableAnnualLv = availableAnnualLv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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




    public Long getRequestId() {
        return requestId;
    }



    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }



    @Override
    public String toString() {
        return "ApproveTimeDTO [employeeId=" + employeeId + ", requestId=" + requestId + ", firstName=" + firstName
                + ", lastName=" + lastName + ", availableSickLv=" + availableSickLv + ", availableAnnualLv="
                + availableAnnualLv + ", email=" + email + ", availableLv=" + availableLv + ", reason=" + reason
                + ", hoursOfLvRequested=" + hoursOfLvRequested + ", typeofLv=" + typeofLv + ", lvStartDate="
                + lvStartDate + ", lvEndDate=" + lvEndDate + ", status=" + status + "]";
    }

    
    
}
