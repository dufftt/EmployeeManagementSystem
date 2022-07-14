package com.cts.employeservice.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private long eId;
    
    private String EmployeeName;
    private long Phone;
    private String Designation;
    private long projectId;
    private long dId;
    private String Location;
    private long Salary;


    public Employee() {
    }


    public Employee(long eId, String employeeName, long phone, String designation, long projectId, long dId,
            String location, long salary) {
        this.eId = eId;
        EmployeeName = employeeName;
        Phone = phone;
        Designation = designation;
        this.projectId = projectId;
        this.dId = dId;
        Location = location;
        Salary = salary;
    }


    public long geteId() {
        return eId;
    }


    public void seteId(long eId) {
        this.eId = eId;
    }


    public String getEmployeeName() {
        return EmployeeName;
    }


    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }


    public long getPhone() {
        return Phone;
    }


    public void setPhone(long phone) {
        Phone = phone;
    }


    public String getDesignation() {
        return Designation;
    }


    public void setDesignation(String designation) {
        Designation = designation;
    }


    public long getProjectId() {
        return projectId;
    }


    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }


    public long getdId() {
        return dId;
    }


    public void setdId(long dId) {
        this.dId = dId;
    }


    public String getLocation() {
        return Location;
    }


    public void setLocation(String location) {
        Location = location;
    }


    public long getSalary() {
        return Salary;
    }


    public void setSalary(long salary) {
        Salary = salary;
    }


    @Override
    public String toString() {
        return "Employee [Designation=" + Designation + ", EmployeeName=" + EmployeeName + ", Location=" + Location
                + ", Phone=" + Phone + ", Salary=" + Salary + ", dId=" + dId + ", eId=" + eId + ", projectId="
                + projectId + "]";
    }

    
    

}
