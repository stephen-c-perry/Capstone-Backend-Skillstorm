package com.hourlogix.backend_api.repository;

import com.hourlogix.backend_api.dto.PaystubDTO;
import com.hourlogix.backend_api.dto.PaystubSelectViewDTO;
import com.hourlogix.backend_api.model.Paystub;
import com.hourlogix.backend_api.model.PaystubSelectView;
import com.hourlogix.backend_api.model.PaystubView;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface PaystubRepo extends JpaRepository<Paystub, Long> {


    @Query(value = "SELECT " + 
                    "p.pay_date AS payDate, " +
                    "p.period_beginning AS beginDate, " +
                    "p.period_ending AS endDate, " +
                    "((e.hourly_wage * p.hours_worked) - ((e.hourly_wage * p.hours_worked) * 0.18)) AS checkAmount " + 
                    "From paystubs p " +
                    "JOIN employee e ON p.employee_id = e.employee_id " +
                    "where e.employee_id = ?1 " +
                    "ORDER BY p.period_ending DESC",
            nativeQuery = true)
    
    List<PaystubSelectView> getAllPaystubsSelectView(Long id);

    //################################################################

    @Query(value = "SELECT " +
                   "p.paystub_id AS paystubId, " +
                   "e.employee_id AS empId, " +
                   "CAST(SUBSTRING(e.ssn, -4) AS UNSIGNED) AS ssnLast4, " +
                   "e.first_name AS firstName, " +
                   "e.last_name AS lastName, " +
                   "p.period_beginning AS beginDate, " +
                   "p.period_ending AS endDate, " +
                   "p.hours_worked AS numHours, " +
                   "e.hourly_wage AS hourlyWage, " +
                   "e.hourly_wage * p.hours_worked AS grossPeriod, " + // Calculate gross_period
                   "(e.hourly_wage * p.hours_worked) * 0.18 AS deductPeriod, " + // Calculate deduct_period
                   "(e.hourly_wage * p.hours_worked) - ((e.hourly_wage * p.hours_worked) * 0.18) AS netPeriod " + // Calculate net_period
                   "FROM paystubs p " +
                   "JOIN employee e ON p.employee_id = e.employee_id " +
                   "Where paystub_id = ?1 " +
                   "ORDER BY p.period_ending DESC",
                    //can i return a view instead so that I can create new fields for YTD Gross, YTD Deductions, YTD Net?

           nativeQuery = true)

    PaystubView getByPaystubId(Long paystubId);      


}
