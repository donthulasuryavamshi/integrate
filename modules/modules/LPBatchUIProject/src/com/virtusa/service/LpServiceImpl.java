package com.virtusa.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.virtusa.dao.LpDAO;
import com.virtusa.entities.TrainingCalendar;
import com.virtusa.entities.BatchDetails;
import com.virtusa.entities.Lp;
import com.virtusa.helper.FactoryLpDAO;
import com.virtusa.model.BatchModel;
import com.virtusa.model.CalendarModel;
import com.virtusa.model.LPModel;
import com.virtusa.model.UpdateLpDetailsModel;

public class LpServiceImpl implements LpService {

	LpDAO lpDao;

	public LpServiceImpl() {

		this.lpDao = FactoryLpDAO.createLpDAO();

	}

	@Override
	public List<LPModel> retrieveLpDetails(String userId) {
   
		List<LPModel> lpModelList=new ArrayList<>();
		
		try {
			List<Lp> lp = lpDao.lpProfileView(userId);
			for(Lp lp2:lp) {
				LPModel lpModel=new LPModel();
				lpModel.setFullName(lp2.getFirstName() + " " + lp2.getLastName());
				lpModel.setContactDetails("Email:" + lp2.getEmail() + " Phone Number:" + lp2.getPhoneNumber());
				lpModel.setRole(lp2.getRole()) ;
				lpModel.setAddress("City:" + lp2.getCity() + "State: " + lp2.getState() + "Country:" + lp2.getCountry());
				lpModel.setId("ID:"+lp2.getLpId());
				lpModel.setBatchId("Batch ID:"+lp2.getBatchId());
				lpModelList.add(lpModel);
				String batchid=lp2.getBatchId();
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return lpModelList;

	}

	@Override
	public boolean storeLpService(UpdateLpDetailsModel updateModel) throws ClassNotFoundException, SQLException {

		Lp lp = new Lp();
		lp.setFirstName(updateModel.getFirstName());
		lp.setLastName(updateModel.getLastName());
		lp.setEmail(updateModel.getEmail());
		lp.setPhoneNumber(updateModel.getPhoneNumber());
		lp.setRole(updateModel.getRole());
		lp.setCity(updateModel.getCity());
		lp.setState(updateModel.getState());
		lp.setCountry(updateModel.getCountry());
		lp.setLpId(updateModel.getUserId());

		boolean stored = lpDao.storeLpDetails(lp);

		boolean result = false;
		if (stored)	
			
			result = true;
		else
			result = false;

		return result;
	}

	@Override
	public  List<CalendarModel> retrieveCalendar(String userid) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		 List<CalendarModel> calendarModelList=new ArrayList<>();
		
			  
			  List<TrainingCalendar> calendarList=lpDao.viewTrainingCalendar(userid);
		
				
			  for(TrainingCalendar trainingCalendar:calendarList) {
				  CalendarModel calendarModel2=new CalendarModel();
				calendarModel2.setBatchId(trainingCalendar.getBatchId());
				calendarModel2.setDate(trainingCalendar.getDate());
				calendarModel2.setTopic(trainingCalendar.getTopic());
				calendarModelList.add(calendarModel2);
			  }

				return calendarModelList;	
}


@Override
public  List<BatchModel> retrieveBatchDetails(String user) throws ClassNotFoundException, SQLException {
	
	 List<BatchModel> batchModelList=new ArrayList<>();
	 
	 List<BatchDetails> batchDetailsList =lpDao.viewBatchDetails(user);
	 
	 for(BatchDetails batchDetails:batchDetailsList) {
		 
		 BatchModel batchModel=new BatchModel();
		 batchModel.setBatchId(batchDetails.getBatchId());
		 batchModel.setBatchName(batchDetails.getBatchName());
		 batchModel.setBatchMentorId(batchDetails.getBatchMentorId());
		 batchModel.setBatchVenueId(batchDetails.getBatchVenueId());
		 batchModel.setBatchCapacity(batchDetails.getBatchCapacity());
		 
		batchModelList.add(batchModel);
		 
	 }
	
	return batchModelList;
	
}
}
