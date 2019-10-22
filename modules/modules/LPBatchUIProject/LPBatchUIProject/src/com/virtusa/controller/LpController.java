package com.virtusa.controller;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.TrainingCalendar;
import com.virtusa.helper.FactoryLpDAO;
import com.virtusa.helper.FactoryLpService;
import com.virtusa.model.CalendarModel;
import com.virtusa.model.LpModel;
import com.virtusa.model.UpdateLpDetailsModel;
import com.virtusa.model.UserModel;
import com.virtusa.service.LpService;
import com.virtusa.view.LpView;

public class LpController {

	LpService lpService;

	public LpController() {

		this.lpService = FactoryLpService.createLpService();
	}

	public void retrieveLpDetails(String userId) {

		List<LpModel> lpModel = lpService.retrieveLpDetails(userId);
		LpView lpView = new LpView();
		lpView.viewLpDetails(lpModel);

	}

	public void storeLp(UpdateLpDetailsModel updateLpDetailsView) throws ClassNotFoundException, SQLException {

		LpView lpView = new LpView();

		boolean result = lpService.storeLpService(updateLpDetailsView);
		UserModel userModel=new UserModel();
		 String userId=userModel.getUserId();
	
		if (result) {
			lpView.storeSuccess(userId);

		} else {

			lpView.storeUnsuccess(userId);
		}

	}
	
	
	public void viewTraningCalendar() {
		
		try {
			List<CalendarModel> models=lpService.retrieveCalendar();
			LpView lpView=new LpView();
			lpView.showTraningCalendar(models);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}
