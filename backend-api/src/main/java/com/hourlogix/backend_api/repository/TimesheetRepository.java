package com.hourlogix.backend_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.model.Timesheet;

public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {

    List<Timesheet> findByEmployee(Employee employee);
}
