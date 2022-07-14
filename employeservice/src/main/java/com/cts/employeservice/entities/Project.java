package com.cts.employeservice.entities;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Project {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long pId;
	private long ProjectID;
	private String ProjectName;
	private long uId;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date StartDate;
	
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date EndDate;
	

	private String ProjectDomain;
	private String ProjectStatus;
	
	
	@UpdateTimestamp
	private LocalDateTime updatedtime;
	
	private String updatedby;    //plid or empid something
	
	
	

	protected Project() {
		
	}


	public Project(long projectID, String projectName, long uId, Date startDate, Date endDate, String projectDomain,
			String projectStatus, LocalDateTime updatedtime, String updatedby) {
		super();
		ProjectID = projectID;
		ProjectName = projectName;
		this.uId = uId;
		StartDate = startDate;
		EndDate = endDate;
		ProjectDomain = projectDomain;
		ProjectStatus = projectStatus;
		this.updatedtime = updatedtime;
		this.updatedby = updatedby;
	}


	public long getpId() {
		return pId;
	}


	public void setpId(long pId) {
		this.pId = pId;
	}

	public long getProjectID() {
		return ProjectID;
	}


	public void setProjectID(long projectID) {
		ProjectID = projectID;
	}


	public String getProjectName() {
		return ProjectName;
	}


	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}
	public long getuId() {
		return uId;
	}

	public Date getStartDate() {
		return StartDate;
	}


	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public Date getEndDate() {
		return EndDate;
	}

	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}

	public String getProjectDomain() {
		return ProjectDomain;
	}

	public void setProjectDomain(String projectDomain) {
		ProjectDomain = projectDomain;
	}


	public String getProjectStatus() {
		return ProjectStatus;
	}


	public void setProjectStatus(String projectStatus) {
		ProjectStatus = projectStatus;
	}


	public LocalDateTime getUpdatedtime() {
		return updatedtime;
	}

	public void setUpdatedtime(LocalDateTime updatedtime) {
		this.updatedtime = updatedtime;
	}


	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}


	@Override
	public String toString() {
		return "Project [pId=" + pId + ", ProjectID=" + ProjectID + ", ProjectName=" + ProjectName + ", uId=" + uId
				+ ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", ProjectDomain=" + ProjectDomain
				+ ", ProjectStatus=" + ProjectStatus + ", updatedtime=" + updatedtime + ", updatedby=" + updatedby
				+ "]";
	}

	

}
