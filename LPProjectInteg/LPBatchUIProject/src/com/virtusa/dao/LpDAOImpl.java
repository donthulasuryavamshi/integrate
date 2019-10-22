package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.TrainingCalendar;
import com.virtusa.entities.BatchDetails;
import com.virtusa.entities.Lp;

import com.virtusa.integrate.ConnectionManager;

public class LpDAOImpl implements LpDAO {

	@Override
	public  List<Lp> lpProfileView(String userId) throws ClassNotFoundException, SQLException {
		
		Connection connection = ConnectionManager.openConnection();

		PreparedStatement statement = connection.prepareStatement("select lp_id,first_name,last_name,phone_number,email,role,city,state,country,batch_id from lp_details where lp_id=?");
		
		statement.setString(1, userId);

		ResultSet resultSet = statement.executeQuery();
		Lp lp = new Lp();
       List<Lp>lpList=new ArrayList<Lp>();
		while (resultSet.next()) {

			lp.setLpId(resultSet.getString("lp_id"));
			lp.setFirstName(resultSet.getString("first_name"));
			lp.setLastName(resultSet.getString("last_name"));
			lp.setEmail(resultSet.getString("email"));
			lp.setPhoneNumber(resultSet.getString("phone_number"));
			lp.setRole(resultSet.getString("role"));
			lp.setCity(resultSet.getString("city"));
			lp.setState(resultSet.getString("state"));
			lp.setCountry(resultSet.getString("country"));
			lp.setBatchId(resultSet.getString("batch_id"));
			lpList.add(lp);
			System.out.println(lpList);
		}
		ConnectionManager.closeConnection();
		return lpList;

	}

	@Override
	public boolean storeLpDetails(Lp lp) throws ClassNotFoundException, SQLException {

		boolean result = false;
		Connection connection;

		connection = ConnectionManager.openConnection();
		PreparedStatement statement;

		statement = connection.prepareStatement(
				"UPDATE lp_details SET first_name=?,last_name=?,phone_number=?,email=?,role=?,city=?,state=?,country=? where lp_id=?");

		statement.setString(1, lp.getFirstName());
		statement.setString(2, lp.getLastName());
		statement.setString(3, lp.getPhoneNumber());
		statement.setString(4, lp.getEmail());
		statement.setString(5, lp.getRole());
		statement.setString(6, lp.getCity());
		statement.setString(7, lp.getState());
		statement.setString(8, lp.getCountry());
		statement.setString(9, lp.getLpId());
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
	public List<TrainingCalendar> viewTrainingCalendar(String user) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//boolean result = false;
		System.out.println(user);
		String batchid = null;
		List<TrainingCalendar> calendarList = new ArrayList<TrainingCalendar>();
		Connection connection = ConnectionManager.openConnection();
		
		PreparedStatement statement = connection.prepareStatement("select batch_id from lp_details where lp_id=?");
		statement.setString(1, user);
		ResultSet resultset = statement.executeQuery();
		if(resultset.next()) {
			batchid = resultset.getString(1);
		}
		System.out.println(batchid);
		//String s ="JSP";
		PreparedStatement statement1 = connection.prepareStatement("select * from training_calendar where batch_id=?");
		statement1.setString(1, batchid);
		//statement1.setString(2, s);
		ResultSet resultset1 = statement1.executeQuery();
		while (resultset1.next()) {
			//System.out.println(resultset1.getString(1));			
			TrainingCalendar trainingCalendar = new TrainingCalendar();
			trainingCalendar.setBatchId(resultset1.getString("batch_id"));
			
			java.sql.Date 
			date=resultset1.getDate("date_to");
			
			trainingCalendar.setDate(date.toLocalDate());
			
			trainingCalendar.setTopic(resultset1.getString("course"));
			calendarList.add(trainingCalendar);
			System.out.println(calendarList);
		}

		ConnectionManager.closeConnection();
		return calendarList;

	}
	
	
	
	
	@Override
	public List<BatchDetails> viewBatchDetails(String user) throws ClassNotFoundException, SQLException {
		//System.out.println(batch);
		System.out.println(user);
		//boolean result = false;
		String batch_id = null;
		Connection connection = ConnectionManager.openConnection();
		PreparedStatement statement = connection.prepareStatement("select batch_id from lp_details where lp_id=?");
		statement.setString(1, user);
		ResultSet result1 = statement.executeQuery();
		if(result1.next())
			batch_id = result1.getString(1);
		
		System.out.println(batch_id);
		
		PreparedStatement stmt = connection.prepareStatement("select * from  batch_details where batch_id = ?");
		stmt.setString(1, batch_id);	
		ResultSet resultSet = stmt.executeQuery();	 
		List<BatchDetails> batchDetailsList = new ArrayList<BatchDetails>();
		while(resultSet.next()) {
			
			BatchDetails batchDetails=new BatchDetails();
			batchDetails.setBatchId(resultSet.getString("batch_id"));
			batchDetails.setBatchName(resultSet.getString("batch_name"));
			batchDetails.setBatchMentorId(resultSet.getString("batch_mentor_id"));
			batchDetails.setBatchVenueId(resultSet.getString("batch_venue_id"));
			batchDetails.setBatchCapacity(resultSet.getString("batch_capacity"));
			//batchDetails.setStartDate("");
			//batchDetails.setEndDate("");
			batchDetailsList.add(batchDetails);
			System.out.println(batchDetailsList);
		
		}
		System.out.println(batchDetailsList);
         ConnectionManager.closeConnection();		
	
		return batchDetailsList;
		
	}

}
