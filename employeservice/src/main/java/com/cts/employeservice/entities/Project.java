package com.cts.employeservice.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Project {
	
	@Id
	private long pId;
	
	private long dId;
	private String pName;
	private String pDomain;
	private long managerId;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date startDate;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date endDate;
	
	private boolean status;
	
	public Project()
	{
		
	}
	

	public Project(long pId, long dId, String pName, String pDomain, long managerId, Date startDate, Date endDate,
			boolean status) {
		super();
		this.pId = pId;
		this.dId = dId;
		this.pName = pName;
		this.pDomain = pDomain;
		this.managerId = managerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
	}


	public long getpId() {
		return pId;
	}

	public void setpId(long pId) {
		this.pId = pId;
	}

	public long getdId() {
		return dId;
	}

	public void setdId(long dId) {
		this.dId = dId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpDomain() {
		return pDomain;
	}

	public void setpDomain(String pDomain) {
		this.pDomain = pDomain;
	}

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Project [pId=" + pId + ", dId=" + dId + ", pName=" + pName + ", pDomain=" + pDomain + ", managerId="
				+ managerId + ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + "]";
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	

}
