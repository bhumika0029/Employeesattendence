package com.employee.attendance.management.system.employee.attendance.management.system.service;

import com.employee.attendance.management.system.employee.attendance.management.system.entity.Attendance;
import com.employee.attendance.management.system.employee.attendance.management.system.entity.Employee;
import com.employee.attendance.management.system.employee.attendance.management.system.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    private AttendanceRepository repo;

    public void markAttendance(Employee emp, String status) {
        Attendance a = new Attendance();
        a.setDate(LocalDate.now());     // 🔴 Error is here
        a.setStatus(status);            // (potential error)
        a.setEmployee(emp);             // (potential error)

        repo.save(a);
    }

    public List<Attendance> getByEmployeeId(Long id) {
        return repo.findByEmployeeId(id);
    }

    public List<Attendance> getAll() {
        return repo.findAll();
    }
}