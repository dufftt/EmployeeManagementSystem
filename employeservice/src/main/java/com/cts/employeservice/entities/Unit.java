package com.cts.employeservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Unit {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long uId; 

	private long UnitID;
	private String UnitName;
	
	public Unit()
	{
		
	}
	

	public Unit(long unitID, String unitName) {
		super();
		UnitID = unitID;
		UnitName = unitName;
	}


	public long getUnitID() {
		return UnitID;
	}

	public void setUnitID(long unitID) {
		UnitID = unitID;
	}

	public String getUnitName() {
		return UnitName;
	}

	public void setUnitName(String unitName) {
		UnitName = unitName;
	}

	public long getuId() {
		return uId;
	}


	@Override
	public String toString() {
		return "Unit [uId=" + uId + ", UnitID=" + UnitID + ", UnitName=" + UnitName + "]";
	}
	
	
	
	

	
	
	
	
	

}
