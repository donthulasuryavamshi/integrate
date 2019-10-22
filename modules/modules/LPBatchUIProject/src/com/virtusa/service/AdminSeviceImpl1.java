package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.dao.LpRegistrationDao;
import com.virtusa.entities.Lp1;
import com.virtusa.helper.FactoryAdminService;
import com.virtusa.model.LPRegistrationModel;

public class AdminSeviceImpl1 implements AdminService1 {

	private LpRegistrationDao lpregistrationdao;
	public AdminSeviceImpl1() {
		// TODO Auto-generated constructor stub
		this.lpregistrationdao = FactoryAdminService.createLpRegistrationDao();
	}
	@Override
	public boolean createLpRegistration(LPRegistrationModel lpRegistrationModel)
			throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean result = false;

		Lp1 lp = new Lp1();
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
