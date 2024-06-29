package com.hourlogix.backend_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hourlogix.backend_api.model.Timesheet;

public interface TimekeepRepository extends JpaRepository<Timesheet, Long> {
}
