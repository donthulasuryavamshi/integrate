package com.virtusa.dao;

import java.sql.SQLException;

import com.virtusa.entities.Lp1;
public interface LpRegistrationDao {
	public boolean createLpRegistration(Lp1 lp) throws ClassNotFoundException, SQLException; 
		
}
