package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.dao.LpRegistrationDao;
import com.virtusa.helper.FactoryAdminService;
import com.virtusa.model.LPRegistrationModel;
import com.virusa.entities.LP;

public class AdminServiceImpl implements AdminService {
	private LpRegistrationDao lpregistrationdao;
	public AdminServiceImpl() {
		// TODO Auto-generated constructor stub
		this.lpregistrationdao = FactoryAdminService.createLpRegistrationDao();
	}
	@Override
	public boolean createLpRegistration(LPRegistrationModel lpRegistrationModel)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean result = false;

		LP lp = new LP();
		lp.setLpId(lpRegistrationModel.getLpId());
		lp.setFirstName(lpRegistrationModel.getFirstName());
		lp.setLastName(lpRegistrationModel.getLastName());
		lp.setPhoneNumber(lpRegistrationModel.getPhoneNumber());
		lp.setEmail(lpRegistrationModel.getEmail());
		lp.setDesignation(lpRegistrationModel.getDesignation());
		lp.setCity(lpRegistrationModel.getCity());
		lp.setState(lpRegistrationModel.getState());
		lp.setCountry(lpRegistrationModel.getCountry());

		boolean stored = lpregistrationdao.createLpRegistration(lp);

		if (stored)	
			
			result = true;
		else
			result = false;

		return result;
	}

}
