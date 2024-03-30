package com.springbootdemo.service;

import com.springbootdemo.model.Employee;

import java.util.List;

public interface EmployeeService {


    Employee saveEmployeeData(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(String id);

    String deleteEmployeeById(String id);
}
