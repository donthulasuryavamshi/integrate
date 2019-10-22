package com.virtusa.model;

public class VenueDetailsModel {

	private String venueId;
	private String venueName;
	private String venueCapacity;
	private String venueLocation;
	private String batchName;
	
	
	public String getBatchName() {
		return batchName;
	}
	
	public void setBatchName(String batchName) {
		this.batchName=batchName;
	}
	
	public String getVenueId() {
		return venueId;
	}

	public void setVenueId(String venueId) {
		this.venueId = venueId;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueCapacity() {
		return venueCapacity;
	}

	public void setVenueCapacity(String venueCapacity) {
		this.venueCapacity = venueCapacity;
	}

	public String getVenueLocation() {
		return venueLocation;
	}

	public void setVenueLocation(String venueLocation) {
		this.venueLocation = venueLocation;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((batchName == null) ? 0 : batchName.hashCode());
		result = prime * result + ((venueCapacity == null) ? 0 : venueCapacity.hashCode());
		result = prime * result + ((venueId == null) ? 0 : venueId.hashCode());
		result = prime * result + ((venueLocation == null) ? 0 : venueLocation.hashCode());
		result = prime * result + ((venueName == null) ? 0 : venueName.hashCode());
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
		VenueDetailsModel other = (VenueDetailsModel) obj;
		if (batchName == null) {
			if (other.batchName != null)
				return false;
		} else if (!batchName.equals(other.batchName))
			return false;
		if (venueCapacity == null) {
			if (other.venueCapacity != null)
				return false;
		} else if (!venueCapacity.equals(other.venueCapacity))
			return false;
		if (venueId == null) {
			if (other.venueId != null)
				return false;
		} else if (!venueId.equals(other.venueId))
			return false;
		if (venueLocation == null) {
			if (other.venueLocation != null)
				return false;
		} else if (!venueLocation.equals(other.venueLocation))
			return false;
		if (venueName == null) {
			if (other.venueName != null)
				return false;
		} else if (!venueName.equals(other.venueName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VenueDetailsModel [venueId=" + venueId + ", venueName=" + venueName + ", venueCapacity=" + venueCapacity
				+ ", venueLocation=" + venueLocation + ", batchName=" + batchName + "]";
	}
	
	
}
