package com.virtusa.service;

import java.sql.SQLException;

import com.virtusa.dao.UserDAO;
import com.virtusa.helper.FactoryUserDAO;
import com.virtusa.helper.FactoryUserDAO1;
import com.virtusa.model.UserModel;

public class UserServiceImpl1 implements UserService {

	UserDAO userDAO = null;

	public UserServiceImpl1() {

		this.userDAO = FactoryUserDAO1.createUseDAO();

	}

	@Override
	public boolean userAuthenticationService(UserModel userModel) {

		boolean userValid = false;
		
			try {
				userValid = userDAO.userAuth(userModel.getUserId(), userModel.getPassword());
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		return userValid;

	}
}
