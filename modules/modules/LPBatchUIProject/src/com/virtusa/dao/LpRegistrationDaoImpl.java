package com.virtusa.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.virtusa.entities.Lp1;
import com.virtusa.integrate.ConnectionManager;

public class LpRegistrationDaoImpl implements LpRegistrationDao {

	@Override
	public boolean createLpRegistration(Lp1 lp) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		boolean result = false;
		Connection connection;

		connection = ConnectionManager.openConnection();
		

		PreparedStatement statement=
				connection.prepareStatement("insert into lp_details_table(lp_id,first_name,last_name,phone_number,email,designation,city,state,country) values(?,?,?,?,?,?,?,?,?) ");
		
		statement.setString(1, lp.getLpId());
		statement.setString(2, lp.getFirstName());
		statement.setString(3, lp.getLastName());
		statement.setInt(4, lp.getPhoneNumber());
		statement.setString(5, lp.getEmail());
		statement.setString(6, lp.getDesignation());
		statement.setString(7, lp.getCity());
		statement.setString(8, lp.getState());
		statement.setString(9, lp.getCountry());
		
		System.out.println(statement);

		int row = statement.executeUpdate();

		ConnectionManager.closeConnection();
		if (row > 0)

			result = true;
		else
			return false;

		return result;
		
	}

}
