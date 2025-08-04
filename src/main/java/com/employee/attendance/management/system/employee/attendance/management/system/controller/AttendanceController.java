package com.employee.attendance.management.system.employee.attendance.management.system.controller;

import com.employee.attendance.management.system.employee.attendance.management.system.entity.Employee;
import com.employee.attendance.management.system.employee.attendance.management.system.service.AttendanceService;
import com.employee.attendance.management.system.employee.attendance.management.system.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import jakarta.servlet.http.HttpSession;

@Controller
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employee/attendance")
    public String markAttendance(@RequestParam String status, HttpSession session) {
        Employee emp = (Employee) session.getAttribute("user");
        if (emp == null) return "redirect:/login?error=sessionExpired";
        attendanceService.markAttendance(emp, status);
        return "redirect:/employee/view-attendance";
    }

    @GetMapping("/employee/view-attendance")
    public String viewOwnAttendance(Model model, HttpSession session) {
        Employee emp = (Employee) session.getAttribute("user");
        if (emp == null) return "redirect:/login?error=sessionExpired";
        model.addAttribute("attendanceList", attendanceService.getByEmployeeId(emp.getId()));
        return "employee/view_attendance";
    }

    @GetMapping("/admin/view-all-attendance")
    public String viewAllAttendance(Model model, HttpSession session) {
        Employee emp = (Employee) session.getAttribute("user");
        if (emp == null || !"ADMIN".equals(emp.getRole())) return "redirect:/login?error=unauthorized";
        model.addAttribute("attendanceList", attendanceService.getAll());
        return "admin/view_all_attendance";
    }
}
