package com.data.employee.EmployeeRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.employee.employeeDataModel.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
