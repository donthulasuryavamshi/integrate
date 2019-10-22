package com.virtusa.dao;

import java.sql.SQLException;
import com.virusa.entities.LP;

public interface LpRegistrationDao {
	public boolean createLpRegistration(LP lp) throws ClassNotFoundException, SQLException; 
		
}
