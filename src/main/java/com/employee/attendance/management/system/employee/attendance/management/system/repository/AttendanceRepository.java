package com.employee.attendance.management.system.employee.attendance.management.system.repository;

import com.employee.attendance.management.system.employee.attendance.management.system.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findByEmployeeId(Long employeeId);
}
