package com.virtusa.entities;

import java.time.LocalDate;

public class BatchDetails {
	
	private String batchId;
	private String batchName;
	private String batchCapacity;
	private String batchMentorId ;
	private String batchVenueId ;
	 LocalDate startDate ;
	 LocalDate endDate; 
	 
	public String getBatchId() {
		return batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getBatchCapacity() {
		return batchCapacity;
	}

	public void setBatchCapacity(String batchCapacity) {
		this.batchCapacity = batchCapacity;
	}

	public String getBatchMentorId() {
		return batchMentorId;
	}

	public void setBatchMentorId(String batchMentorId) {
		this.batchMentorId = batchMentorId;
	}

	public String getBatchVenueId() {
		return batchVenueId;
	}

	public void setBatchVenueId(String batchVenueId) {
		this.batchVenueId = batchVenueId;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchCapacity == null) ? 0 : batchCapacity.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((batchMentorId == null) ? 0 : batchMentorId.hashCode());
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + ((batchVenueId == null) ? 0 : batchVenueId.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BatchDetails other = (BatchDetails) obj;
		if (batchCapacity == null) {
			if (other.batchCapacity != null)
				return false;
		} else if (!batchCapacity.equals(other.batchCapacity))
			return false;
		if (batchId == null) {
			if (other.batchId != null)
				return false;
		} else if (!batchId.equals(other.batchId))
			return false;
		if (batchMentorId == null) {
			if (other.batchMentorId != null)
				return false;
		} else if (!batchMentorId.equals(other.batchMentorId))
			return false;
		if (batchName == null) {
			if (other.batchName != null)
				return false;
		} else if (!batchName.equals(other.batchName))
			return false;
		if (batchVenueId == null) {
			if (other.batchVenueId != null)
				return false;
		} else if (!batchVenueId.equals(other.batchVenueId))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BatchDetails [batchId=" + batchId + ", batchName=" + batchName + ", batchCapacity=" + batchCapacity
				+ ", batchMentorId=" + batchMentorId + ", batchVenueId=" + batchVenueId + ", startDate=" + startDate
				+ ", endDate=" + endDate + "]";
	}
	
	
	 

}
