package com.virtusa.service;

import java.sql.SQLException;

import java.util.List;

import com.virtusa.model.AdminModel;
import com.virtusa.model.BatchDetailsModel;
import com.virtusa.model.LPRegistrationModel;
import com.virtusa.model.LpDetailsModel;
import com.virtusa.model.MentorDetailsModel;
import com.virtusa.model.UpdateAdminModel;
import com.virtusa.model.VenueDetailsModel;
import com.virtusa.model.ViewBatchDetailsModel;

public interface AdminService {

	public List<AdminModel> retrieveAdminDetails(String userId);
	public List<ViewBatchDetailsModel> getBatchDetails();
	public List<LpDetailsModel> lpViewLpDetails();
	public boolean storeAdminService(UpdateAdminModel updateAdminModel) throws ClassNotFoundException, SQLException;
	public List<MentorDetailsModel> getMentorDetails();

	public List<BatchDetailsModel> getBatchDetails1();

	public int updatedmentordetails(String mentorid, String batchid);
	public List<VenueDetailsModel> getVenueDetails();
	public List<BatchDetailsModel>  getBatchDetails2();

	public int updatedVenuedetails(String venueId, String batchId);
	//public boolean createLpRegistration(LPRegistrationModel lpRegistrationModel) throws ClassNotFoundException, SQLException;
}
