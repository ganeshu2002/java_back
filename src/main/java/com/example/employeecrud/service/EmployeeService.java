package com.example.employeecrud.service;

import com.example.employeecrud.model.Employee;
import com.example.employeecrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get All
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get By ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // Update
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Employee emp = employeeRepository.findById(id).orElseThrow();

        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setDob(employeeDetails.getDob());
        emp.setDoj(employeeDetails.getDoj());
        emp.setAge(employeeDetails.getAge());
        emp.setAddress(employeeDetails.getAddress());
        emp.setMobile(employeeDetails.getMobile());
        emp.setCity(employeeDetails.getCity());
        emp.setState(employeeDetails.getState());
        emp.setCountry(employeeDetails.getCountry());
        emp.setTenth(employeeDetails.getTenth());
        emp.setTwelfth(employeeDetails.getTwelfth());
        emp.setGraduation(employeeDetails.getGraduation());

        return employeeRepository.save(emp);
    }

    // Delete
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
