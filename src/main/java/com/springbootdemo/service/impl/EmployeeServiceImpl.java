package com.springbootdemo.service.impl;

import com.springbootdemo.ExceptionHandeller.EmployeeNotFoundException;
import com.springbootdemo.model.Employee;
import com.springbootdemo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee saveEmployeeData(Employee employee) {
        if (employee.getEmpId() == null || employee.getEmpId().isEmpty()) {
            employee.setEmpId(UUID.randomUUID().toString());
        }

        employees.add(employee);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {

        return employees.stream()
                .filter(employee -> employee.getEmpId().equalsIgnoreCase(id))
                .findFirst().orElseThrow(() -> new EmployeeNotFoundException("" + "Employee not found::" + id));
    }

    @Override
    public String deleteEmployeeById(String id) {

        Employee employee = employees.stream().filter(employee1 -> employee1.getEmpId().equalsIgnoreCase(id)).findFirst().get();
        employees.remove(employee);
        return "Employee deleted with id :: " + id;
    }
}
