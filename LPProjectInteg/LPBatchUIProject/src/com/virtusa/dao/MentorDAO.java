package com.virtusa.dao;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.TrainingCalendar;
import com.virtusa.entities.Mentor;

public interface MentorDAO{
	
	
   
	
	List<TrainingCalendar> viewTrainingCalendar() throws ClassNotFoundException, SQLException;

	boolean storeMentorDetails(Mentor mentor) throws ClassNotFoundException, SQLException;

	List<Mentor> mentorProfileView(String userId) throws ClassNotFoundException, SQLException;

}
