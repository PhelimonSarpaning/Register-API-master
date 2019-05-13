package edu.uark.commands.employee;

import org.apache.commons.lang3.StringUtils;

import edu.uark.commands.ResultCommandInterface;
import edu.uark.commands.products.ProductCreateCommand;
import edu.uark.controllers.exceptions.ConflictException;
import edu.uark.controllers.exceptions.NotFoundException;
import edu.uark.controllers.exceptions.UnprocessableEntityException;
import edu.uark.models.api.Employee;
import edu.uark.models.api.Product;
import edu.uark.models.entities.EmployeeEntity;
import edu.uark.models.repositories.EmployeeRepository;
import edu.uark.models.repositories.ProductRepository;
import edu.uark.models.repositories.interfaces.EmployeeRepositoryInterface;
import edu.uark.models.repositories.interfaces.ProductRepositoryInterface;

public class EmployeeLogin implements ResultCommandInterface<Employee>{

	@Override
	public Employee execute() {
		//Validations
		if (StringUtils.isBlank(this.apiEmployee.getEmployeeID())) {
			throw new UnprocessableEntityException("EmployeeID");
		}
		
		EmployeeEntity employeeEntity = this.employeeRepository.byEmployeeID(this.apiEmployee.getEmployeeID());
		EmployeeEntity employeePass = this.employeeRepository.byEmployeePassword(this.apiEmployee.getPassword());
		if (employeeEntity != null && employeePass != null) {
			System.out.println("User Exists");//check to see if username exists in database
			
			
			return new Employee(employeeEntity);
		}
		else {
			throw new NotFoundException("Employee");
		}
		//this.apiEmployee.setId(employeeEntity.getId());//return the unique record id.
		//return this.apiEmployee;
	}
	
	//Properties
		private Employee apiEmployee;
		public Employee getApiEmployee() {
			return this.apiEmployee;
		}
		
		public EmployeeLogin setApiEmployee(Employee apiEmployee) {
			this.apiEmployee = apiEmployee;
			return this;
		}
		private EmployeeRepositoryInterface employeeRepository;
		public EmployeeRepositoryInterface getEmployeeRepository() {
			return this.employeeRepository;
		}
		
		public EmployeeLogin setEmployeeRepository(EmployeeRepositoryInterface employeeRepository) {
			this.employeeRepository = employeeRepository;
			return this;
		}
		
		public EmployeeLogin() {
			this.employeeRepository = new EmployeeRepository();
		}
}
