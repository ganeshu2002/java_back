package com.example.employeecrud.repository;

import com.example.employeecrud.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
    // ✅ Find employees by firstName and dob
    @Query("SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.dob = :dob")
    List<Employee> findByFirstNameAndDob(@Param("firstName") String firstName, @Param("dob") LocalDate dob);
}
