package com.virtusa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.entities.TrainingCalendar;
import com.virtusa.entities.Mentor;

import com.virtusa.integrate.ConnectionManager;
import com.virtusa.model.UserModel;

public class MentorDAOImpl implements MentorDAO {

	@Override
	public  List<Mentor> mentorProfileView(String userId) throws ClassNotFoundException, SQLException {
		
		Connection connection = ConnectionManager.openConnection();

		PreparedStatement statement = connection.prepareStatement("select mentor_id,first_name,last_name,phone_number,email,role,city,state,country from mentor_details where mentor_id=?");
		
		statement.setString(1, userId);

		ResultSet resultSet = statement.executeQuery();
		Mentor mentor = new Mentor();
       List<Mentor>mentorList=new ArrayList<Mentor>();
		while (resultSet.next()) {

			mentor.setMentorId(resultSet.getString("mentor_id"));
			mentor.setFirstName(resultSet.getString("first_name"));
			mentor.setLastName(resultSet.getString("last_name"));
			mentor.setEmail(resultSet.getString("email"));
			mentor.setPhoneNumber(resultSet.getString("phone_number"));
			mentor.setRole(resultSet.getString("role"));
			mentor.setCity(resultSet.getString("city"));
			mentor.setState(resultSet.getString("state"));
			mentor.setCountry(resultSet.getString("country"));
			mentorList.add(mentor);
		}
  System.out.println(mentorList);
		ConnectionManager.closeConnection();
		return mentorList;

	}

	@Override
	public boolean storeMentorDetails(Mentor mentor)throws ClassNotFoundException, SQLException {

		boolean result = false;
		Connection connection;

		connection = ConnectionManager.openConnection();
		PreparedStatement statement;

		statement = connection.prepareStatement(
				"UPDATE mentor_details_table SET first_name=?,last_name=?,phone_number=?,email=?,role=?,city=?,state=?,country=? where mentor_id=?");

		statement.setString(1, mentor.getFirstName());
		statement.setString(2, mentor.getLastName());
		statement.setString(3, mentor.getPhoneNumber());
		statement.setString(4, mentor.getEmail());
		statement.setString(5, mentor.getRole());
		statement.setString(6, mentor.getCity());
		statement.setString(7, mentor.getState());
		statement.setString(8, mentor.getCountry());
		statement.setString(9, mentor.getMentorId());
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
	public List<TrainingCalendar> viewTrainingCalendar() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection connection;

		connection = ConnectionManager.openConnection();
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("select batch_id,date,course from training_calendar");

		List<TrainingCalendar> calendarList = new ArrayList<TrainingCalendar>();
		while (resultSet.next()) {
			TrainingCalendar trainingCalendar = new TrainingCalendar();
			trainingCalendar.setBatchId(resultSet.getString("batch_id"));
			//trainingCalendar.setDate(resultSet.getString("date"));
			trainingCalendar.setTopic(resultSet.getString("course"));
			calendarList.add(trainingCalendar);

		}

		ConnectionManager.closeConnection();
		return calendarList;

	}

}
