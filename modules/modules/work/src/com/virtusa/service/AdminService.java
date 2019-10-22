package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.model.LPRegistrationModel;

public interface AdminService {
	public boolean createLpRegistration(LPRegistrationModel lpRegistrationModel) throws ClassNotFoundException, SQLException;
}
