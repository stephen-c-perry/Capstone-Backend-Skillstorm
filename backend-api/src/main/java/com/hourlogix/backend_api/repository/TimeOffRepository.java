package com.hourlogix.backend_api.repository;

import com.hourlogix.backend_api.model.Employee;
import com.hourlogix.backend_api.model.LeaveRequest;


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface TimeOffRepository extends JpaRepository<LeaveRequest, Long> {

    List<LeaveRequest> findByEmployee(Employee employee);
  
}
