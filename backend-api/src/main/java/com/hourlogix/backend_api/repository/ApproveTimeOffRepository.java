package com.hourlogix.backend_api.repository;

import com.hourlogix.backend_api.model.LeaveRequest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ApproveTimeOffRepository extends JpaRepository<LeaveRequest, Long> {
      @Query("SELECT lvr FROM LeaveRequest lvr WHERE lvr.status = :status")
    List<LeaveRequest> findByStatus(@Param("status") String status);
}
