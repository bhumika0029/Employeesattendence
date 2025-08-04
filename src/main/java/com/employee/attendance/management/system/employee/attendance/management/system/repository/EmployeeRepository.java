package com.employee.attendance.management.system.employee.attendance.management.system.repository;

import com.employee.attendance.management.system.employee.attendance.management.system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmail(String email);
}