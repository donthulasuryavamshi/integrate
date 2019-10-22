package com.virtusa.dao;
import java.sql.SQLException;

import java.util.List;

import com.virtusa.entities.Admin;
import com.virtusa.entities.Lp;
import com.virtusa.model.BatchDetailsModel;
import com.virtusa.model.LpDetailsModel;
import com.virtusa.model.MentorDetailsModel;
import com.virtusa.model.VenueDetailsModel;
import com.virtusa.model.ViewBatchDetailsModel;

public interface AdminDAO {

	public  List<Admin> adminProfileView(String userId) throws ClassNotFoundException, SQLException;
		
	public List<ViewBatchDetailsModel> viewBatchDetails() throws ClassNotFoundException, SQLException;

	public List<LpDetailsModel> lpDetailsListShow() throws ClassNotFoundException, SQLException;
    public boolean updateAdminProfile(Admin admin) throws ClassNotFoundException, SQLException;
    public boolean createLpRegistration(Lp lp) throws ClassNotFoundException, SQLException; 
    public List<MentorDetailsModel> getMentorDetails() throws SQLException, ClassNotFoundException;
	public List<BatchDetailsModel> getBatchDetails() throws ClassNotFoundException, SQLException;
	public int getUpdatedMentorDetails(String mentorid,String batchid) throws ClassNotFoundException, SQLException;
	public List<VenueDetailsModel> getVenueDetails() throws ClassNotFoundException, SQLException;
	public List<BatchDetailsModel> getBatchDetails1() throws ClassNotFoundException, SQLException; 
	public int getUpdatedVenueDetails(String venueId, String batchId) throws ClassNotFoundException, SQLException;
	
}
