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

    // ✅ Add a new employee with education details
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    

    // ✅ Get all employees with education details
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ✅ Get employee by ID
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    // ✅ Update employee details
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        return employeeRepository.findById(id)
                .map(employee -> {
                    employee.setFirstName(employeeDetails.getFirstName());
                    employee.setLastName(employeeDetails.getLastName());
                    employee.setDob(employeeDetails.getDob());
                    employee.setDoj(employeeDetails.getDoj());
                    employee.setAge(employeeDetails.getAge());
                    employee.setAddress(employeeDetails.getAddress());
                    employee.setMobile(employeeDetails.getMobile());
                    employee.setCity(employeeDetails.getCity());
                    employee.setState(employeeDetails.getState());
                    employee.setCountry(employeeDetails.getCountry());
                    
                    // ✅ Update education list
                    employee.setEducation(employeeDetails.getEducation());

                    return employeeRepository.save(employee);
                }).orElseThrow(() -> new RuntimeException("Employee not found with ID: " + id));
    }

    // ✅ Delete employee by ID
    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with ID: " + id);
        }
        employeeRepository.deleteById(id);
    }
}
