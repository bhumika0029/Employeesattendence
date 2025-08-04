package com.employee.attendance.management.system.employee.attendance.management.system.controller;

import com.employee.attendance.management.system.employee.attendance.management.system.entity.Employee;
import com.employee.attendance.management.system.employee.attendance.management.system.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam String email, @RequestParam String password, HttpSession session) {
        Employee emp = employeeService.findByEmail(email);
        if (emp != null && emp.getPassword().equals(password)) {
            session.setAttribute("user", emp);
            if (emp.getRole().equals("ADMIN")) return "redirect:/admin/admin_view_attendance";
            else return "redirect:/employee/view_attendance";
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
