package com.virtusa.controller;

import javax.servlet.RequestDispatcher;

import com.virtusa.client.UserLogin;
import com.virtusa.entities.Lp;
import com.virtusa.helper.FactoryUserService;
import com.virtusa.model.UserModel;
import com.virtusa.service.UserService;
import com.virtusa.view.LpView;

public class UserController {
	UserService userService;

	public UserController() {

		this.userService = FactoryUserService.createUserService();
	}

	public boolean userAuthentication(String userId, String password) {

		UserModel userModel = new UserModel();
		userModel.setUserId(userId);
		userModel.setPassword(password);

		boolean userType = userService.userAuthenticationService(userModel);
		if (userType==true) {

			

		} else {
			UserLogin userLogin = new UserLogin();
			userLogin.invalidLogin();
		}
		return userType;

	}
}
