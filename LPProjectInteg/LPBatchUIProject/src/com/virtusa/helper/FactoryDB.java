package com.virtusa.helper;
import com.virtusa.dao.AdminDAO;
import com.virtusa.dao.AdminDAOImpl;
import com.virtusa.service.AdminService;
import com.virtusa.service.AdminServiceImpl;



public class FactoryDB{
	
	public static AdminDAO createAdminDAO(){
		AdminDAO adminDAO=new AdminDAOImpl();
		return adminDAO;
	}
	

	public static AdminService createAdminService(){
		AdminService mentorservice=new AdminServiceImpl();
		return mentorservice;
		
		}

}
