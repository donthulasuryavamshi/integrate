package com.virtusa.dao;

import java.sql.SQLException;

import com.virtusa.entities.Lp;
public interface LpRegistrationDao {
	public boolean createLpRegistration(Lp lp) throws ClassNotFoundException, SQLException; 
		
}
