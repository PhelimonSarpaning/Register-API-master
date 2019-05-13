package edu.uark.models.entities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import edu.uark.dataaccess.entities.BaseEntity;
import edu.uark.dataaccess.repository.DatabaseTable;
import edu.uark.models.api.Employee;
import edu.uark.models.entities.fieldnames.EmployeeFieldNames;

public class EmployeeEntity extends BaseEntity<EmployeeEntity> {
	@Override
	protected void fillFromRecord(ResultSet rs) throws SQLException {
		this.employeeID = rs.getString(EmployeeFieldNames.EMPLOYEE_ID);
		this.f_name = rs.getString(EmployeeFieldNames.FIRST_NAME);
		this.l_name = rs.getString(EmployeeFieldNames.LAST_NAME);
		this.manage = rs.getString(EmployeeFieldNames.MANAGE);
		this.active = rs.getString(EmployeeFieldNames.ACTIVE);
		this.password = rs.getString(EmployeeFieldNames.PASSWORD);
		this.role = rs.getString(EmployeeFieldNames.ROLE);
	}

	@Override
	protected Map<String, Object> fillRecord(Map<String, Object> record) {
		record.put(EmployeeFieldNames.EMPLOYEE_ID, this.employeeID);
		record.put(EmployeeFieldNames.FIRST_NAME, this.f_name);
		record.put(EmployeeFieldNames.LAST_NAME, this.l_name);
		record.put(EmployeeFieldNames.MANAGE, this.manage);
		record.put(EmployeeFieldNames.ACTIVE, this.active);
		record.put(EmployeeFieldNames.ROLE, this.role);
		record.put(EmployeeFieldNames.PASSWORD, this.password);
		//record.put(EmployeeFieldNames.COUNT, this.count);
		
		return record;
	}

	private String employeeID;
	public String getEmployeeID() {
		return this.employeeID;
	}
	public EmployeeEntity setEmployeeID(String employeeID) {
		if (!StringUtils.equals(this.employeeID, employeeID)) {
			this.employeeID = employeeID;
			this.propertyChanged(EmployeeFieldNames.EMPLOYEE_ID);
		}
		
		return this;
	}
	
	private String f_name;
	public String getFirstName() {
		return this.f_name;
	}
	public EmployeeEntity setFirstName(String f_name) {
		if (!StringUtils.equals(this.f_name, f_name)) {
			this.f_name = f_name;
			this.propertyChanged(EmployeeFieldNames.FIRST_NAME);
		}
		
		return this;
	}
	
	private String l_name;
	public String getLastName() {
		return this.l_name;
	}
	public EmployeeEntity setLastName(String l_name) {
		if (!StringUtils.equals(this.l_name, l_name)) {
			this.l_name = l_name;
			this.propertyChanged(EmployeeFieldNames.LAST_NAME);
		}
		
		return this;
	}
	
	private String manage;
	public String getManage() {
		return this.manage;
	}

	public EmployeeEntity setManage(String manage) {
		if (!StringUtils.equals(this.manage, manage)) {
			this.manage = manage;
			this.propertyChanged(EmployeeFieldNames.MANAGE);
		}
		
		return this;
	}
	
	private String role;
	public String getRole() {
		return this.role;
	}
	
	public EmployeeEntity setRole(String role) {
		if (!StringUtils.equals(this.role, role)) {
			this.role = role;
			this.propertyChanged(EmployeeFieldNames.ROLE);
		}
		
		return this;
	}
	
	private String active;
	public String getActive() {
		return this.active;
	}
   
	public EmployeeEntity setActive(String active) {
		if (!StringUtils.equals(this.active, active)) {
			this.active = active;
			this.propertyChanged(EmployeeFieldNames.ACTIVE);
		}
		
		return this;
	}
	
	private String password;
	public String getPassword() {
		return this.password;
	}
	
	public EmployeeEntity setPassword(String password) {
		if (!StringUtils.equals(this.password, password)) {
			this.password = password;
			this.propertyChanged(EmployeeFieldNames.PASSWORD);
		}
		
		return this;
	}
//	private int count;
//	public int getCount() {
//		return this.count;
//	}
//	public ProductEntity setCount(int count) {
//		if (this.count != count) {
//			this.count = count;
//			this.propertyChanged(ProductFieldNames.COUNT);
//		}
//		
//		return this;
//	}
//	
	public Employee synchronize(Employee apiEmployee) {
		this.setEmployeeID(apiEmployee.getEmployeeID());
		this.setFirstName(apiEmployee.getFirstName());
		this.setLastName(apiEmployee.getLastName());
		this.setRole(apiEmployee.getRole());
		this.setManage(apiEmployee.getManage());
		this.setActive(apiEmployee.getActive());
		this.setPassword(apiEmployee.getPassword());
		
		apiEmployee.setId(this.getId());
		apiEmployee.setCreatedOn(this.getCreatedOn());// same as getStamp() in other functions
		
		return apiEmployee;
	}
	
	public EmployeeEntity() {
		super(DatabaseTable.EMPLOYEE);
		
		//this.count = -1;
		this.f_name = StringUtils.EMPTY;
		this.l_name = StringUtils.EMPTY;
		this.manage = StringUtils.EMPTY;
		this.active = StringUtils.EMPTY;
		this.password = StringUtils.EMPTY;
		this.role = StringUtils.EMPTY;
		this.employeeID = StringUtils.EMPTY;
	}
	
	public EmployeeEntity(Employee apiEmployee) {
		super(DatabaseTable.EMPLOYEE);
		
		//this.count = apiProduct.getCount();
		this.employeeID = apiEmployee.getEmployeeID();
		this.f_name = apiEmployee.getFirstName();
		this.l_name = apiEmployee.getLastName();
		this.manage = apiEmployee.getManage();
		this.active = apiEmployee.getActive();
		this.password =DigestUtils.sha256Hex(apiEmployee.getPassword());
		this.role = apiEmployee.getRole();
	}
}
