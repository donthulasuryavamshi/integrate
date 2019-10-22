package com.virtusa.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.Admin;
import com.virtusa.entities.Lp;
import com.virtusa.integrate.ConnectionManager;
import com.virtusa.model.AdminModel;
import com.virtusa.model.BatchDetailsModel;
import com.virtusa.model.LpDetailsModel;
import com.virtusa.model.MentorDetailsModel;
import com.virtusa.model.VenueDetailsModel;
import com.virtusa.model.ViewBatchDetailsModel;

public class AdminDAOImpl implements AdminDAO {

	@Override
	public List<ViewBatchDetailsModel> viewBatchDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=ConnectionManager.openConnection();
		Statement statement2=connection.createStatement();
		ResultSet resultSet=statement2.executeQuery("select * from batch_details");
		
		List<ViewBatchDetailsModel> batchDetailsModelList = new ArrayList<>();
		while(resultSet.next()) {
			ViewBatchDetailsModel viewBatchDetailsModel = new ViewBatchDetailsModel();
			viewBatchDetailsModel.setBatchId(resultSet.getString("batch_id"));
			viewBatchDetailsModel.setBatchName(resultSet.getString("batch_name"));
			viewBatchDetailsModel.setBatchCapacity(resultSet.getString("batch_capacity"));
			viewBatchDetailsModel.setBatchMentorId(resultSet.getString("batch_mentor_id"));
			viewBatchDetailsModel.setBatchVenueId(resultSet.getString("batch_venue_id"));
			viewBatchDetailsModel.setBatchStartDate(resultSet.getDate("batch_startDate"));
			viewBatchDetailsModel.setBatchEndDate(resultSet.getDate("batch_endDate"));
			batchDetailsModelList.add(viewBatchDetailsModel);	
			
			System.out.println("batchDetailsModelList"+batchDetailsModelList);
		}
		
		ConnectionManager.closeConnection();
		return batchDetailsModelList;
	}
	
	@Override
    public List<LpDetailsModel> lpDetailsListShow() throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        Connection connection = ConnectionManager.openConnection();
        Statement statement =connection.createStatement();
        List<LpDetailsModel> lpdetailsModellist = new ArrayList<>();
        ResultSet res = statement.executeQuery("select * from lp_details");
        while(res.next()) {
            LpDetailsModel lpdetailsmodel = new LpDetailsModel();
            lpdetailsmodel.setLpId(res.getString("lp_id"));
            lpdetailsmodel.setFirstName(res.getString("first_name"));
            lpdetailsmodel.setLastName(res.getString("last_name"));
           // lpdetailsmodel.setDob(res.getDate("dob"));
            lpdetailsmodel.setPhoneNumber(res.getString("phone_number"));
            lpdetailsmodel.setEmail(res.getString("email"));
            lpdetailsmodel.setDesignation(res.getString("role"));
            lpdetailsmodel.setCity(res.getString("city"));
            lpdetailsmodel.setState(res.getString("state"));
            lpdetailsmodel.setCountry(res.getString("country"));
            lpdetailsModellist.add(lpdetailsmodel);
        }
        
        System.out.println(lpdetailsModellist);
   
        ConnectionManager.closeConnection();
        return lpdetailsModellist;
	}

	@Override
	public boolean updateAdminProfile(Admin admin) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 Connection connection = ConnectionManager.openConnection();
		 PreparedStatement statement=connection.prepareStatement("UPDATE Admin_Details SET first_name=?,last_name=?,phone_number=?,email=?,role=?,city=?,state=?,country=? where admin_id=?");

		 statement.setString(1, admin.getFirstName());
			statement.setString(2, admin.getLastName());
			statement.setString(3, admin.getPhoneNumber());
			statement.setString(4, admin.getEmail());
			statement.setString(5, admin.getRole());
			statement.setString(6, admin.getCity());
			statement.setString(7, admin.getState());
			statement.setString(8, admin.getCountry());
			statement.setString(9, admin.getAdminId());
			int rows=statement.executeUpdate();
			ConnectionManager.closeConnection();
			boolean result=false;
			if (rows > 0)

				result = true;
			else
				return false;

			return result;
			
		
	}

	@Override
	public List<Admin> adminProfileView(String userId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection = ConnectionManager.openConnection();
		System.out.println(userId);
PreparedStatement statement1 = connection.prepareStatement("select admin_id,first_name,last_name,phone_number,email,role,city,state,country from Admin_Details where admin_id=?");
		
		statement1.setString(1, userId);

		ResultSet resultSet = statement1.executeQuery();
		
		
		List<Admin> adminList = new ArrayList<>();
		
		while (resultSet.next()) {
			Admin admin = new Admin();
			admin.setAdminId(resultSet.getString("admin_id"));
			admin.setFirstName(resultSet.getString("first_name"));
			admin.setLastName(resultSet.getString("last_name"));
			admin.setEmail(resultSet.getString("email"));
			admin.setPhoneNumber(resultSet.getString("phone_number"));
			admin.setRole(resultSet.getString("role"));
			admin.setCity(resultSet.getString("city"));
			admin.setState(resultSet.getString("state"));
			admin.setCountry(resultSet.getString("country"));
			adminList.add(admin);
		}
		System.out.println(adminList);
		ConnectionManager.closeConnection();
		return adminList;
		
	}

	@Override
	public boolean createLpRegistration(Lp lp) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection connection;

		connection = ConnectionManager.openConnection();
		

		PreparedStatement statement=
				connection.prepareStatement("insert into lp_details_table(lp_id,first_name,last_name,phone_number,email,role,city,state,country) values(?,?,?,?,?,?,?,?,?) ");
		
		statement.setString(1, lp.getLpId());
		statement.setString(2, lp.getFirstName());
		statement.setString(3, lp.getLastName());
		statement.setString(4, lp.getPhoneNumber());
		statement.setString(5, lp.getEmail());
		statement.setString(6, lp.getRole());
		statement.setString(7, lp.getCity());
		statement.setString(8, lp.getState());
		statement.setString(9, lp.getCountry());
		
		System.out.println(statement);

		int row = statement.executeUpdate();

		ConnectionManager.closeConnection();
		if (row > 0)

			result = true;
		else
			return false;

		return result;
	
	}

	@Override
	public List<MentorDetailsModel> getMentorDetails() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select md.mentor_id, md.first_name,md.last_name,md.phone_number, md.email,bt.batch_name from mentor_details md left join batch_details bt  ON  md.mentor_id = bt.batch_mentor_id");
		
		List<MentorDetailsModel> mentordetailsList=new ArrayList<>();
		System.out.println(resultSet.getFetchSize()+"   resultset size");
		while(resultSet.next()) {
			MentorDetailsModel mentorDetails=new MentorDetailsModel();
			mentorDetails.setMentorid(resultSet.getString("mentor_id"));
			mentorDetails.setFirstName(resultSet.getString("first_name"));
			mentorDetails.setLastName(resultSet.getString("last_name"));
			mentorDetails.setEmail(resultSet.getString("email"));
			mentorDetails.setPhonenumber(resultSet.getInt("phone_number"));
			mentorDetails.setBatchname(resultSet.getString("batch_name"));
			mentordetailsList.add(mentorDetails);
			System.out.println("megyg "+mentordetailsList);
		}
		
		ConnectionManager.closeConnection();
		return mentordetailsList;
		
	}

	@Override
	public List<BatchDetailsModel> getBatchDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select batch_name,batch_id  from batch_details where batch_mentor_id is NULL");
		List<BatchDetailsModel> batchdetailsList=new ArrayList<>();
		
		while(resultSet.next()) {
			BatchDetailsModel batchDetails=new BatchDetailsModel();
			batchDetails.setBatchName(resultSet.getString("batch_name"));
			batchDetails.setBatchId(resultSet.getString("batch_id"));
			batchdetailsList.add(batchDetails);
			
			System.out.println("dsffdes"+batchdetailsList);
		}
		
		ConnectionManager.closeConnection();
		return batchdetailsList;
	
	}

	@Override
	public int getUpdatedMentorDetails(String mentorid, String batchid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=ConnectionManager.openConnection();
		PreparedStatement statement=connection.prepareStatement("update batch_details set batch_mentor_id = ? where batch_id = ?");

		statement.setString(1,mentorid);
		statement.setString(2,batchid);

		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();
		
		return rows;
		
	}

	@Override
	public List<VenueDetailsModel> getVenueDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		
		ResultSet resultSet=
				statement.executeQuery("select vn.venue_id,vn.venue_name,vn.venue_capacity,vn.venue_location,bt.batch_name from venue_details vn left join batch_details bt ON vn.venue_id=bt.batch_venue_id");
		List<VenueDetailsModel> venuedetailsList=new ArrayList<>();
		System.out.println(resultSet);
		while(resultSet.next()) {
		VenueDetailsModel venueDetails=new VenueDetailsModel();
		venueDetails.setVenueId(resultSet.getString("venue_id"));
		venueDetails.setVenueName(resultSet.getString("venue_name"));
		venueDetails.setVenueCapacity(resultSet.getString("venue_capacity"));
		venueDetails.setVenueLocation(resultSet.getString("venue_location"));
		venueDetails.setBatchName(resultSet.getString("batch_name"));
		
		venuedetailsList.add(venueDetails);}
	System.out.println("dsf"+venuedetailsList);
	
	ConnectionManager.closeConnection();
	return venuedetailsList;
	
	}

	@Override
	public int getUpdatedVenueDetails(String venueId, String batchId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
Connection connection=ConnectionManager.openConnection();
		
		PreparedStatement statement=connection.prepareStatement("update batch set batch_venue_id = ? where batch_id = ?");

		statement.setString(1, venueId);
		statement.setString(2, batchId);
		
		int rows=statement.executeUpdate();
		ConnectionManager.closeConnection();

		return rows;
		
	
	}

	@Override
	public List<BatchDetailsModel> getBatchDetails1() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=
				statement.executeQuery("select batch_name,batch_id  from batch_details where batch_venue_id is NULL");
		List<BatchDetailsModel> batchdetailsList=new ArrayList<>();
		
		while(resultSet.next()) {
			BatchDetailsModel batchDetails=new BatchDetailsModel();
			batchDetails.setBatchName(resultSet.getString("batch_name"));
			batchDetails.setBatchId(resultSet.getString("batch_id"));
			batchdetailsList.add(batchDetails);
			
			System.out.println("dsffdes"+batchdetailsList);
		}
		
		ConnectionManager.closeConnection();
		return batchdetailsList;
		
	}

	
}
