package com.virtusa.helper;

import com.virtusa.dao.LpRegistrationDao;
import com.virtusa.dao.LpRegistrationDaoImpl;
import com.virtusa.model.LPRegistrationModel;
import com.virtusa.service.AdminService1;
import com.virtusa.service.AdminSeviceImpl1;
public class FactoryAdminService {
	public static LpRegistrationDao createLpRegistrationDao() {
		LpRegistrationDao lpRegistrationDao = new LpRegistrationDaoImpl();
		return lpRegistrationDao;
	}
	public static AdminService1 createAdminService() {
		AdminService1 adminSerivce = new AdminSeviceImpl1();
		return adminSerivce;
	}
}
