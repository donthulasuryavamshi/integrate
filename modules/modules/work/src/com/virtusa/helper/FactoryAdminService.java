package com.virtusa.helper;

import com.virtusa.dao.LpRegistrationDao;
import com.virtusa.dao.LpRegistrationDaoImpl;
import com.virtusa.model.LPRegistrationModel;
import com.virtusa.service.AdminService;
import com.virtusa.service.AdminServiceImpl;

public class FactoryAdminService {
	public static LpRegistrationDao createLpRegistrationDao() {
		LpRegistrationDao lpRegistrationDao = new LpRegistrationDaoImpl();
		return lpRegistrationDao;
	}
	public static AdminService createAdminService() {
		AdminService adminSerivce = new AdminServiceImpl();
		return adminSerivce;
	}
}
