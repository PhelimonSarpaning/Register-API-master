package edu.uark.commands.employee;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeByEmployeeIDQuery implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		if (StringUtils.isBlank(this.employeeID)) {
			throw new UnprocessableEntityException("employeeid");
		}
		
		EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeID(this.employeeID);
		if (employeeEntity != null) {
			return new Employee(employeeEntity);
		} else {
			throw new NotFoundException("Product");
		}
	}

	//Properties
	private String employeeID;
	public String getemployeeID() {
		return this.employeeID;
	}
	public EmployeeByEmployeeIDQuery setEmployeeID(String EmployeeID) {
		this.employeeID = EmployeeID;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeByEmployeeIDQuery setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeByEmployeeIDQuery() {
		this.employeeRepository = new EmployeeRepository();
	}
}
