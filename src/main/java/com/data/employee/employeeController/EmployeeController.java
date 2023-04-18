package com.data.employee.employeeController;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.data.employee.employeeDataModel.Employee;
import com.data.employee.employeeService.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/**
     * This API endpoint is used to update an employee's details in the database
     * @param  id contains employeeId
     * @param employee contains all employee details
     * @return ResponseEntity with status OK (200) and saved employee .
     * @throws Exception
     */
	@PutMapping(value="/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable long id, @RequestBody Employee employee) throws Exception {
		//4 digits and alpha
		employee.setEmployeeId(id);
		return ResponseEntity.ok().body(this.employeeService.updateEmployee(employee));
	}
	
	/**
     * This API endpoint is used to delete an employee record in the database
     * @param  id contains employeeId
     * @return ResponseEntity with status OK (200).
     * @throws Exception
     */
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") long id) throws Exception {
		return this.employeeService.deleteEmployeeById(id);
	}
	
	/**
	 * This API endpoint is used to get all employeelist in the database
     * @return list of employees
     * @throws Exception
     */
	@RequestMapping(value="")
	public ResponseEntity<List<Employee>> getAllEmployee() throws Exception{
		return ResponseEntity.ok().body(employeeService.getAllEmployees());
	}

}
