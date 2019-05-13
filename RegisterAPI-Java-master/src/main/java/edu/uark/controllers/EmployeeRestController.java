package edu.uark.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.uark.commands.employee.EmployeeByEmployeeIDQuery;
import edu.uark.commands.employee.EmployeeCreateCommand;
import edu.uark.commands.employee.EmployeeDeleteCommand;
import edu.uark.commands.employee.EmployeesQuery;
import edu.uark.commands.employee.EmployeeUpdateCommand;
import edu.uark.commands.employee.EmployeeQuery;
import edu.uark.commands.employee.EmployeeLogin;
import edu.uark.models.api.Employee;
//import edu.uark.models.api.Product;

@RestController
@RequestMapping(value = "/api/employee")
public class EmployeeRestController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Employee> getEmployees() {
		
		return (new EmployeesQuery()).execute();
	}
	
	@RequestMapping(value = "/{recordId}", method = RequestMethod.GET)
	public Employee getId(@PathVariable UUID recordId) {
		return (new EmployeeQuery()).execute();
	}
	

//	@RequestMapping(value = "/{productId}", method = RequestMethod.GET)
//	public Product getProduct(@PathVariable UUID productId) {
//		return (new ProductQuery()).
//			setProductId(productId).
//			execute();
//	}
//
	@RequestMapping(value = "/employeeId/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployeeByEmployeeId(@PathVariable String employeeId) {
		return (new EmployeeByEmployeeIDQuery()).
			setEmployeeID(employeeId).
			execute();
	}
	
	
//	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Employee createProduct(@RequestBody Employee employee) {
		return (new EmployeeCreateCommand()).
			setApiEmployee(employee).
			execute();
	}
//	
//	@RequestMapping(value = "/{productId}", method = RequestMethod.PUT)
//	public Product updateProduct(@PathVariable UUID productId, @RequestBody Product product) {
//		return (new ProductUpdateCommand()).
//			setProductId(productId).
//			setApiProduct(product).
//			execute();
//	}
//	
//	@RequestMapping(value = "/{productId}", method = RequestMethod.DELETE)
//	public void deleteProduct(@PathVariable UUID productId) {
//		(new ProductDeleteCommand()).
//			setProductId(productId).
//			execute();
//	}
	
	//still in progress
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Employee employeeLogin(@RequestBody Employee employee) {
		//System.out.println("Successful");
		return (new EmployeeLogin()).
				setApiEmployee(employee).
				execute();
		//return "Login Successfully";
	}
//	@ResponseBody
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String employeeLogin(@PathVariable String employeeId, @PathVariable String password) {
//		return "Login Successfully";
//	}
	
	@ResponseBody
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "Successful test. (EmployeeRestController)";
	}
}
