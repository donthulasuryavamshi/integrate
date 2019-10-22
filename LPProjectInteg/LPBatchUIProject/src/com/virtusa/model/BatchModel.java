package com.virtusa.model;

public class BatchModel {
	
	private String batchId;
	private String batchName;
	private String batchCapacity;
	private String batchMentorId ;
	private String batchVenueId ;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchCapacity == null) ? 0 : batchCapacity.hashCode());
		result = prime * result + ((batchId == null) ? 0 : batchId.hashCode());
		result = prime * result + ((batchMentorId == null) ? 0 : batchMentorId.hashCode());
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + ((batchVenueId == null) ? 0 : batchVenueId.hashCode());
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
		BatchModel other = (BatchModel) obj;
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
		return true;
	}

	@Override
	public String toString() {
		return "BatchModel [batchId=" + batchId + ", batchName=" + batchName + ", batchCapacity=" + batchCapacity
				+ ", batchMentorId=" + batchMentorId + ", batchVenueId=" + batchVenueId + "]";
	}
	

}
