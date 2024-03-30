package com.springbootdemo.controller;


import com.springbootdemo.model.Employee;
import com.springbootdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeV2Controller {

    @Autowired
    @Qualifier("employeeV2ServiceImpl")
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee saveEmployeeData(@RequestBody Employee emp) {
        return employeeService.saveEmployeeData(emp);
    }
    @GetMapping("/getAll")
    public List<Employee> getALlEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getEmployeeId(@PathVariable("id") String Id) {
        return employeeService.getEmployeeById(Id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") String Id) {
        return employeeService.deleteEmployeeById(Id);
    }
}

