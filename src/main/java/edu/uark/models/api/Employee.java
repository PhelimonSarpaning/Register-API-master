package edu.uark.models.api;
///////This file is in charge of pulling stuff from the employee database
import java.time.LocalDateTime;
import java.util.UUID;

import edu.uark.models.entities.EmployeeEntity;
import org.apache.commons.codec.digest.DigestUtils;

public class Employee {
	private UUID recordId;
	public UUID getId() {
		return this.recordId;
	}
	public Employee setId(UUID recordId) {
		this.recordId = recordId;
		return this;
	}
	
	private String employeeId;
	public String getEmployeeID() {
		return this.employeeId;
	}
	public Employee setEmployeeID(String employeeId) {
		this.employeeId = employeeId;
		return this;
	}
	
	private String f_name;
	public String getFirstName() {
		return this.f_name;
	}
	public Employee setFirstName(String f_name) {
		this.f_name = f_name;
		return this;
	}
	
	private String l_name;
	public String getLastName() {
		return this.l_name;
	}
	public Employee setLastName(String l_name) {
		this.l_name = l_name;
		return this;
	}
	
	private String role;
	public String getRole() {
		return this.role;
	}
	public Employee setRole(String role) {
		this.role = role;
		return this;
	}
	
	private String manage;
	public String getManage() {
		return this.manage;
	}
	public Employee setManage(String manage) {
		this.manage = manage;
		return this;
	}
	
	private String active;
	public String getActive() {
		return this.active;
	}
	public Employee setActive(String active) {
		this.active = active;
		return this;
	}
	
	private String password;
	public String getPassword() {
		return this.password;
	}
	public Employee setPassword(String password) {
		this.password = password;
		return this;
	}
	
	
	private LocalDateTime createdOn;
	public LocalDateTime getCreatedOn() {
		return this.createdOn;
	}
	public Employee setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
		return this;
	}
	
	public Employee() {
		this.employeeId =" ";
		this.f_name =" ";
		this.l_name =" ";
		this.active =" ";
		this.role =" ";
		this.manage =" ";
		this.password =" ";
		this.recordId = new UUID(0, 0);
		this.createdOn = LocalDateTime.now();
	}
	
	public Employee(EmployeeEntity employeeEntity) {
		this.recordId = employeeEntity.getId();
		this.employeeId = employeeEntity.getEmployeeID();
		this.f_name = employeeEntity.getFirstName();
		this.l_name = employeeEntity.getLastName();
		this.active = employeeEntity.getActive();
		this.role = employeeEntity.getRole();
		this.manage = employeeEntity.getManage();
		this.password = DigestUtils.sha256Hex(employeeEntity.getPassword());//work on hashing database too
		this.createdOn = employeeEntity.getCreatedOn();
	}
}
