package com.data.employee.employeeService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.data.employee.EmployeeRepository.EmployeeRepository;
import com.data.employee.employeeDataModel.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> getAllEmployees() throws Exception {
		try {
			return this.repository.findAll();
		}catch(Exception e) {
			throw new Exception("No records found");
		}
	}

	public Employee updateEmployee(Employee employee) throws Exception {
		Optional<Employee> employeeDb = this.repository.findById(employee.getEmployeeId());
		if(employeeDb.isPresent()) {
			Employee empUpdate = employeeDb.get();
			empUpdate.setEmployeeId(employee.getEmployeeId());
			empUpdate.setEmployeeName(employee.getEmployeeName());
			empUpdate.setDepartment(employee.getDepartment());
			repository.save(empUpdate);
			return empUpdate;
		}else {
			throw new Exception("Record not found with id : " + employee.getEmployeeId());
		}
	}

	public ResponseEntity<HttpStatus> deleteEmployeeById(long id) throws Exception {
		try {
			Optional<Employee> employeeDb = this.repository.findById(id);
			if(employeeDb.isPresent())
				this.repository.deleteById(id);
			else
				throw new Exception("No record Found");
		}catch (Exception e) {
			throw new Exception("Delete not Successful");
		}
		return ResponseEntity.ok(HttpStatus.OK);
		
	}


}
