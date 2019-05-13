package edu.uark.commands.employee;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.controllers.exceptions.ConflictException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;

public class EmployeeCreateCommand implements ResultCommandInterface<Employee> {
	@Override
	public Employee execute() {
		//Validations
		
        // check if employeeid is empty
        if (StringUtils.isBlank(this.apiEmployee.getEmployeeID())) {
			throw new UnprocessableEntityException("EmployeeID");
		}

		EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeID(this.apiEmployee.getEmployeeID());
		if (employeeEntity != null) {
			throw new ConflictException("EmployeeID"); //Lookupcode already defined for another product.
		}
		
		//No ENTITY object was returned from the database, thus the API object's lookupcode must be unique.
		employeeEntity = new EmployeeEntity(apiEmployee); //Create a new ENTITY object from the API object details.
		employeeEntity.save(); //Write, via an INSERT, the new record to the database.
		
		this.apiEmployee.setId(employeeEntity.getId()); //Synchronize information generated by the database upon INSERT.
		this.apiEmployee.setCreatedOn(employeeEntity.getCreatedOn());

		return this.apiEmployee;
	}

	//Properties
	private Employee apiEmployee;
	public Employee getApiEmployee() {
		return this.apiEmployee;
	}
	public EmployeeCreateCommand setApiEmployee(Employee apiEmployee) {
		this.apiEmployee = apiEmployee;
		return this;
	}
	
	private EmployeeRepositoryInterface employeeRepository;
	public EmployeeRepositoryInterface getEmployeeRepository() {
		return this.employeeRepository;
	}
	public EmployeeCreateCommand setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
		this.employeeRepository = employeeRepository;
		return this;
	}
	
	public EmployeeCreateCommand() {
		this.employeeRepository = new EmployeeRepository();
	}
}