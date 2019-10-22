package com.virtusa.helper;
import com.virtusa.service.UserService;
import com.virtusa.service.UserServiceImpl2;

public class FactoryUserService3 {

	public static UserService createUserService() {

		UserService userService = new UserServiceImpl2();
		return userService;

	}

}