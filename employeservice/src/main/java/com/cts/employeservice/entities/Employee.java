package com.cts.employeservice.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long eId;
    
    private long EmployeeId;
    private String EmployeeName;
    private String Employeegender;
    private long EmployeePhone;
    private String EmployeeLocation;
    private String EmployeeDesignation;
    private String EmployeemailId;
    private long uId;
    private long pId;
    
    @UpdateTimestamp
	private LocalDateTime Employeeupdatedtime;
	
	private String Employeeupdatedby; 
	
	private boolean isEmployed;

	public Employee(long employeeId, String employeeName, String employeegender, long employeePhone,
			String employeeLocation, String employeeDesignation, String employeemailId, long uId, long pId,
			LocalDateTime employeeupdatedtime, String employeeupdatedby, boolean isEmployed) {
		super();
		EmployeeId = employeeId;
		EmployeeName = employeeName;
		Employeegender = employeegender;
		EmployeePhone = employeePhone;
		EmployeeLocation = employeeLocation;
		EmployeeDesignation = employeeDesignation;
		EmployeemailId = employeemailId;
		this.uId = uId;
		this.pId = pId;
		Employeeupdatedtime = employeeupdatedtime;
		Employeeupdatedby = employeeupdatedby;
		this.isEmployed = isEmployed;
	}

	public long geteId() {
		return eId;
	}

	public void seteId(long eId) {
		this.eId = eId;
	}

	public long getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(long employeeId) {
		EmployeeId = employeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public String getEmployeegender() {
		return Employeegender;
	}

	public void setEmployeegender(String employeegender) {
		Employeegender = employeegender;
	}

	public long getEmployeePhone() {
		return EmployeePhone;
	}

	public void setEmployeePhone(long employeePhone) {
		EmployeePhone = employeePhone;
	}

	public String getEmployeeLocation() {
		return EmployeeLocation;
	}

	public void setEmployeeLocation(String employeeLocation) {
		EmployeeLocation = employeeLocation;
	}

	public String getEmployeeDesignation() {
		return EmployeeDesignation;
	}

	public void setEmployeeDesignation(String employeeDesignation) {
		EmployeeDesignation = employeeDesignation;
	}

	public String getEmployeemailId() {
		return EmployeemailId;
	}

	public void setEmployeemailId(String employeemailId) {
		EmployeemailId = employeemailId;
	}

	public long getuId() {
		return uId;
	}

	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public LocalDateTime getEmployeeupdatedtime() {
		return Employeeupdatedtime;
	}

	public void setEmployeeupdatedtime(LocalDateTime employeeupdatedtime) {
		Employeeupdatedtime = employeeupdatedtime;
	}

	public String getEmployeeupdatedby() {
		return Employeeupdatedby;
	}

	public void setEmployeeupdatedby(String employeeupdatedby) {
		Employeeupdatedby = employeeupdatedby;
	}

	public boolean isEmployed() {
		return isEmployed;
	}

	public void setEmployed(boolean isEmployed) {
		this.isEmployed = isEmployed;
	}

	@Override
	public String toString() {
		return "Employee [eId=" + eId + ", EmployeeId=" + EmployeeId + ", EmployeeName=" + EmployeeName
				+ ", Employeegender=" + Employeegender + ", EmployeePhone=" + EmployeePhone + ", EmployeeLocation="
				+ EmployeeLocation + ", EmployeeDesignation=" + EmployeeDesignation + ", EmployeemailId="
				+ EmployeemailId + ", uId=" + uId + ", pId=" + pId + ", Employeeupdatedtime=" + Employeeupdatedtime
				+ ", Employeeupdatedby=" + Employeeupdatedby + ", isEmployed=" + isEmployed + "]";
	}
	
	
	
	
	
	

	
	
	
	
    
    
    

}
