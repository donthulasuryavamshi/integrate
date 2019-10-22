package com.virtusa.controller;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.TrainingCalendar;
import com.virtusa.helper.FactoryMentorDAO;
import com.virtusa.helper.FactoryMentorService;
import com.virtusa.model.CalendarModel;
import com.virtusa.model.MentorModel;
import com.virtusa.model.UpdateMentorDetailsModel;
import com.virtusa.model.UserModel;
import com.virtusa.service.MentorService;
import com.virtusa.view.MentorView;

public class MentorController {

	MentorService mentorService;

	public MentorController() {

		this.mentorService = FactoryMentorService.createMentorService();
	}

	public void retrieveMentorDetails(String userId) {

		List<MentorModel> mentorModel = mentorService.retrieveMentorDetails(userId);
		MentorView mentorView = new MentorView();
		mentorView.viewMentorDetails(mentorModel);

	}

	public void storeMentor(UpdateMentorDetailsModel updateMentorDetailsView) throws ClassNotFoundException, SQLException {

		MentorView mentorView = new MentorView();

		boolean result = mentorService.storeMentorService(updateMentorDetailsView);
		UserModel userModel=new UserModel();
		 String userId=userModel.getUserId();
	
		if (result) {
			mentorView.storeSuccess(userId);

		} else {

			mentorView.storeUnsuccess(userId);
		}

	}
	
	
	public void viewTraningCalendar() {
		
		try {
			List<CalendarModel> models=mentorService.retrieveCalendar();
			MentorView mentorView=new MentorView();
			mentorView.showTraningCalendar(models);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}


}
