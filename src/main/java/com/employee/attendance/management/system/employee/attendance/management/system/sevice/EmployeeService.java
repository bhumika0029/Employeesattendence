package com.employee.attendance.management.system.employee.attendance.management.system.service;

import com.employee.attendance.management.system.employee.attendance.management.system.entity.Employee;
import com.employee.attendance.management.system.employee.attendance.management.system.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public Employee findByEmail(String email) {
        return repo.findByEmail(email);
    }

    public List<Employee> listAll() {
        return repo.findAll();
    }

    public Employee get(Long id) {
        return repo.findById(id).orElse(null);
    }

    public void save(Employee emp) {
        repo.save(emp);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
