package com.virtusa.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



import com.virtusa.entities.User;
import com.virtusa.integrate.ConnectionManager;
import com.virtusa.model.UserModel;


public class UserDaoImpl2 implements UserDAO {



	
	@Override
	public boolean userAuth(String userId,String password) throws SQLException, ClassNotFoundException {
		
		
			Connection connection=ConnectionManager.openConnection();
			boolean result=false;
			PreparedStatement statement = connection.prepareStatement("select user_id,user_password from login where(user_id=? and user_password=?)");
			statement.setString(1, userId);
			statement.setString(2, password);
             
         
			
		    ResultSet resultSet=statement.executeQuery();
		 
             if(resultSet.next()) {
            	 
            	    result=true;
            	 
             }else {
            	 
            	 result=false;

             }
		    
             ConnectionManager.closeConnection();
			 return result;
				

}		
}

