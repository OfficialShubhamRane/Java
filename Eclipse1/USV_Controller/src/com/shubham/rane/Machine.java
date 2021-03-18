package com.shubham.rane;

import java.util.Date;

public class Machine {
	private String machineID;
	private Date creationDate = java.util.Calendar.getInstance().getTime();
	private String creatorID  = Login.UNAME;
	private int deploymentMinutes;
	
	public String getMachineID() {
		return machineID;
	}
	public void setMachineID(String machineID) {
		this.machineID = machineID;
	}
	
	@Override
	public String toString() {
		return "Machine [machineID=" + machineID + ", creationDate=" + creationDate + ", creatorID=" + creatorID
				+ ", deploymentMinutes=" + deploymentMinutes + "]";
	}
	
	
}
