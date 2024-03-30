package com.springbootdemo.service.impl;

import com.springbootdemo.entity.EmployeeEntity;
import com.springbootdemo.model.Employee;
import com.springbootdemo.repository.EmployeeEntityRepository;
import com.springbootdemo.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeV2ServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeEntityRepository employeeEntityRepository;

    @Override
    public Employee saveEmployeeData(Employee employee) {

        if (employee.getEmpId() == null || employee.getEmpId().isEmpty()) {
            employee.setEmpId(UUID.randomUUID().toString());
        }
        EmployeeEntity entity = new EmployeeEntity();
        BeanUtils.copyProperties(employee, entity);
        employeeEntityRepository.save(entity);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeEntity> employeesEntityList = employeeEntityRepository.findAll();

        List<Employee> employees = employeesEntityList.stream().map(employeeEntity -> {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeEntity, employee);
            return employee;
        }).collect(Collectors.toList());

        return employees;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeEntity employeeEntity = employeeEntityRepository.findById(id).get();
        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeEntity, employee);
        return employee;
    }

    @Override
    public String deleteEmployeeById(String id) {
        employeeEntityRepository.deleteById(id);
        return "Employee deleted with id :: " + id;
    }
}
