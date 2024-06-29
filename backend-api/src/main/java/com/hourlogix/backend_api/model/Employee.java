package com.hourlogix.backend_api.model;

import java.math.BigDecimal;


import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Employee implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    @NotNull(message = "Name cannot be null")
    private String firstName;

    @NotNull(message = "Name cannot be null")
    private String lastName;

    private Integer yearOfEmployement;

    @NotNull(message = "SSN cannot be null")
    private Long ssn;

    private BigDecimal hourlyWage;

    private Integer availableSickLv;

    private Integer availableAnnualLv;

    private String address;

    private String role;

    @Email(message = "Email should be valid")
    private String email;

    private String username;

    private String password;

    public Employee() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getyearOfEmployement() {
        return yearOfEmployement;
    }

    public void setyearOfEmployement(Integer yearOfEmployement) {
        this.yearOfEmployement = yearOfEmployement;
    }

    public Long getSsn() {
        return ssn;
    }

    public void setSsn(Long ssn) {
        this.ssn = ssn;
    }

    public BigDecimal getHourlyWage() {
        return hourlyWage;
    }

    public void setHourlyWage(BigDecimal hourlyWage) {
        this.hourlyWage = hourlyWage;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
                + ", yearOfEmployement=" + yearOfEmployement + ", ssn=" + ssn + ", hourlyWage=" + hourlyWage
                + ", availableSickLv=" + availableSickLv + ", availableAnnualLv=" + availableAnnualLv + ", address="
                + address + ", role=" + role + ", email=" + email + ", username=" + username + ", password=" + password
                + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((yearOfEmployement == null) ? 0 : yearOfEmployement.hashCode());
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        result = prime * result + ((hourlyWage == null) ? 0 : hourlyWage.hashCode());
        result = prime * result + ((availableSickLv == null) ? 0 : availableSickLv.hashCode());
        result = prime * result + ((availableAnnualLv == null) ? 0 : availableAnnualLv.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
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
        Employee other = (Employee) obj;
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
        if (yearOfEmployement == null) {
            if (other.yearOfEmployement != null)
                return false;
        } else if (!yearOfEmployement.equals(other.yearOfEmployement))
            return false;
        if (ssn == null) {
            if (other.ssn != null)
                return false;
        } else if (!ssn.equals(other.ssn))
            return false;
        if (hourlyWage == null) {
            if (other.hourlyWage != null)
                return false;
        } else if (!hourlyWage.equals(other.hourlyWage))
            return false;
        if (availableSickLv == null) {
            if (other.availableSickLv != null)
                return false;
        } else if (!availableSickLv.equals(other.availableSickLv))
            return false;
        if (availableAnnualLv == null) {
            if (other.availableAnnualLv != null)
                return false;
        } else if (!availableAnnualLv.equals(other.availableAnnualLv))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (role == null) {
            if (other.role != null)
                return false;
        } else if (!role.equals(other.role))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        return true;
    }

    @Override
    public List<SimpleGrantedAuthority> getAuthorities() {
        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role.toUpperCase()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @PrePersist
    public void prePersist() {
        this.username = this.firstName + this.employeeId;
    }

}
