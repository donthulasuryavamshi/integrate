package com.virtusa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.MentorDAO;
import com.virtusa.entities.TrainingCalendar;
import com.virtusa.entities.Mentor;
import com.virtusa.helper.FactoryMentorDAO;
import com.virtusa.model.CalendarModel;
import com.virtusa.model.MentorModel;
import com.virtusa.model.UpdateMentorDetailsModel;

public class MentorServiceImpl implements MentorService {

	MentorDAO mentorDao;

	public MentorServiceImpl() {

		this.mentorDao = FactoryMentorDAO.createMentorDAO();

	}

	@Override
	public List<MentorModel> retrieveMentorDetails(String userId) {
   
		List<MentorModel> mentorModelList=new ArrayList<>();
		
		try {
			List<Mentor> mentor = mentorDao.mentorProfileView(userId);
			for(Mentor mentor2:mentor) {
				MentorModel mentorModel=new MentorModel();
				mentorModel.setFullName(mentor2.getFirstName() + " " + mentor2.getLastName());
				mentorModel.setContactDetails("Email:" + mentor2.getEmail() + " Phone Number:" + mentor2.getPhoneNumber());
				mentorModel.setRole(mentor2.getRole()) ;
				mentorModel.setAddress("City:" + mentor2.getCity() + "State: " + mentor2.getState() + "Country:" + mentor2.getCountry());
				mentorModel.setId("ID:"+mentor2.getMentorId());
				mentorModelList.add(mentorModel);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return mentorModelList;
	}
	@Override
	public boolean storeMentorService(UpdateMentorDetailsModel updateModel) throws ClassNotFoundException, SQLException {

		Mentor mentor = new Mentor();
		mentor.setFirstName(updateModel.getFirstName());
		mentor.setLastName(updateModel.getLastName());
		mentor.setEmail(updateModel.getEmail());
		mentor.setPhoneNumber(updateModel.getPhoneNumber());
		mentor.setRole(updateModel.getRole());
		mentor.setCity(updateModel.getCity());
		mentor.setState(updateModel.getState());
		mentor.setCountry(updateModel.getCountry());
		mentor.setMentorId(updateModel.getUserId());

		boolean stored = mentorDao.storeMentorDetails(mentor);

		boolean result = false;
		if (stored)	
			
			result = true;
		else
			result = false;

		return result;
	}

	@Override
	public  List<CalendarModel> retrieveCalendar() throws ClassNotFoundException, SQLException {

		
		 List<CalendarModel> calendarModelList=new ArrayList<>();
		
			  
			  List<TrainingCalendar> calendarList=mentorDao.viewTrainingCalendar();
		
				
			  for(TrainingCalendar trainingCalendar:calendarList) {
				  CalendarModel calendarModel2=new CalendarModel();
				calendarModel2.setBatchId(trainingCalendar.getBatchId());
				calendarModel2.setDate(trainingCalendar.getDate());
				calendarModel2.setTopic(trainingCalendar.getTopic());
				calendarModelList.add(calendarModel2);
			  }

				return calendarModelList;		
		
}
}
