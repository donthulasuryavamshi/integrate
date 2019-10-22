package com.virtusa.helper;

import com.virtusa.dao.UserDAO;
import com.virtusa.dao.UserDaoImpl;
import com.virtusa.dao.UserDaoImpl2;

public class FactoryUserDAO1 {

	public static UserDAO createUseDAO() {

		UserDAO userDAO = new UserDaoImpl2();

		return userDAO;

	}
}
