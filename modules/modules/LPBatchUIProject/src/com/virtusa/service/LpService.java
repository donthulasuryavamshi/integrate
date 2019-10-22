package com.virtusa.service;

import java.sql.SQLException;
import java.util.List;

import com.virtusa.entities.Lp;
import com.virtusa.model.BatchModel;
import com.virtusa.model.CalendarModel;
import com.virtusa.model.LPModel;
import com.virtusa.model.UpdateLpDetailsModel;

public interface LpService {

	boolean storeLpService(UpdateLpDetailsModel updateLpDetailsView) throws ClassNotFoundException, SQLException;
	public List<CalendarModel> retrieveCalendar(String userid) throws ClassNotFoundException, SQLException;
	List<BatchModel> retrieveBatchDetails(String batch) throws ClassNotFoundException, SQLException;
	List<LPModel> retrieveLpDetails(String userId);
	
}
