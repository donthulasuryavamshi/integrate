package com.virtusa.service;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.model.CalendarModel;
import com.virtusa.model.MentorModel;
import com.virtusa.model.UpdateMentorDetailsModel;

public interface MentorService {

	boolean storeMentorService(UpdateMentorDetailsModel updateMentorDetailsView) throws ClassNotFoundException, SQLException;
	public List<CalendarModel> retrieveCalendar() throws ClassNotFoundException, SQLException;


	List<MentorModel> retrieveMentorDetails(String userId);

	
	
}
