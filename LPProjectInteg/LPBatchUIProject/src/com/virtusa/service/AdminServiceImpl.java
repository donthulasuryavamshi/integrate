package com.virtusa.service;

import java.sql.SQLException;


import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.AdminDAO;
import com.virtusa.entities.Admin;
import com.virtusa.helper.FactoryDB;
import com.virtusa.model.AdminModel;
import com.virtusa.model.BatchDetailsModel;
import com.virtusa.model.LpDetailsModel;
import com.virtusa.model.MentorDetailsModel;
import com.virtusa.model.UpdateAdminModel;
import com.virtusa.model.VenueDetailsModel;
import com.virtusa.model.ViewBatchDetailsModel;

public class AdminServiceImpl implements AdminService {

	private AdminDAO adminDAO;
	public AdminServiceImpl() {
		this.adminDAO = FactoryDB.createAdminDAO();
	}
	@Override
	public List<ViewBatchDetailsModel> getBatchDetails() {
		// TODO Auto-generated method stub
		
List<ViewBatchDetailsModel> batchDetailsModelList=new ArrayList<>();
		
		try {
			batchDetailsModelList=adminDAO.viewBatchDetails();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return batchDetailsModelList;
	
	}
	@Override
	public List<LpDetailsModel> lpViewLpDetails() {
		// TODO Auto-generated method stub
List<LpDetailsModel> lpDetailsModelList=new ArrayList<>();
		
		try {
			lpDetailsModelList=adminDAO.lpDetailsListShow();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return lpDetailsModelList;
	}
	@Override
	public boolean storeAdminService(UpdateAdminModel updateAdminModel) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		admin.setFirstName(updateAdminModel.getFirstName());
		admin.setLastName(updateAdminModel.getLastName());
		admin.setEmail(updateAdminModel.getEmail());
		admin.setPhoneNumber(updateAdminModel.getPhoneNumber());
		admin.setRole(updateAdminModel.getRole());
		admin.setCity(updateAdminModel.getCity());
		admin.setState(updateAdminModel.getState());
		admin.setCountry(updateAdminModel.getCountry());
		
		admin.setAdminId(updateAdminModel.getUserId());
		
		System.out.println(admin);

		
		boolean stored = adminDAO.updateAdminProfile(admin);

		boolean result = false;
		if (stored)	
			
			result = true;
		else
			result = false;

		return result;
	}
	@Override
	public List<AdminModel> retrieveAdminDetails(String userId) {

		List<AdminModel> adminModelList=new ArrayList<>();
		
		try {
			List<Admin> admin =adminDAO.adminProfileView(userId);
			for(Admin admin2:admin) {
				AdminModel adminModel = new AdminModel();
				adminModel.setFullName(admin2.getFirstName() + " " + admin2.getLastName());
				adminModel.setContactDetails("Email:" + admin2.getEmail() + " Phone Number:" + admin2.getPhoneNumber());
				adminModel.setRole(admin2.getRole()) ;
				adminModel.setAddress("City:" + admin2.getCity() + "State: " + admin2.getState() + "Country:" + admin2.getCountry());
				adminModel.setId("ID:"+admin2.getAdminId());
				adminModelList.add(adminModel);
				
				System.out.println(adminModelList);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return adminModelList;		
		
	}
	@Override
	public List<MentorDetailsModel> getMentorDetails() {
		// TODO Auto-generated method stub
		List<MentorDetailsModel> mentorDetailsModellist = new ArrayList<MentorDetailsModel>();

		try {
			mentorDetailsModellist = adminDAO.getMentorDetails();
			System.out.println("juhuh"+mentorDetailsModellist);

		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(mentorDetailsModellist);

		return mentorDetailsModellist;
		
	}
	@Override
	public List<BatchDetailsModel> getBatchDetails1() {
		// TODO Auto-generated method stub
		List<BatchDetailsModel> batchDetailsModellist = new ArrayList<BatchDetailsModel>();

		try {
			batchDetailsModellist = adminDAO.getBatchDetails();

		} catch (Exception e) {
			e.printStackTrace();
		}
      System.out.println(batchDetailsModellist);
		return batchDetailsModellist;

	}
	@Override
	public int updatedmentordetails(String mentorid, String batchid) {
		// TODO Auto-generated method stub
		int rowsupdated = 0;
		try {
			rowsupdated = adminDAO.getUpdatedMentorDetails(mentorid, batchid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsupdated;
	
	}
	@Override
	public List<VenueDetailsModel> getVenueDetails() {
		// TODO Auto-generated method stub
		
		List<VenueDetailsModel> venueDetailsModellist = new ArrayList<VenueDetailsModel>();

		try {
			venueDetailsModellist = adminDAO.getVenueDetails();

		} catch (Exception e) {
			e.printStackTrace();
		}
System.out.println(venueDetailsModellist);
		return venueDetailsModellist;
	
	}
	@Override
	public int updatedVenuedetails(String venueId, String batchId) {
		// TODO Auto-generated method stub

		int rowsupdated = 0;
		try {
			rowsupdated = adminDAO.getUpdatedVenueDetails(venueId, batchId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowsupdated;
	
	}
	@Override
	public List<BatchDetailsModel> getBatchDetails2() {
		// TODO Auto-generated method stub
		List<BatchDetailsModel> batchDetailsModellist = new ArrayList<BatchDetailsModel>();

		try {
			batchDetailsModellist = adminDAO.getBatchDetails1();

		} catch (Exception e) {
			e.printStackTrace();
		}
      System.out.println(batchDetailsModellist);
		return batchDetailsModellist;
	
	}
}


