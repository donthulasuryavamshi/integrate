package com.virtusa.helper;

import com.virtusa.service.UserService;
import com.virtusa.service.UserServiceImpl;
import com.virtusa.service.UserServiceImpl1;

public class FactoryUserService2 {

	public static UserService createUserService() {

		UserService userService = new UserServiceImpl1();
		return userService;

	}
}
