package com.virtusa.client;
import java.util.Scanner;
import org.apache.log4j.Logger;

import com.virtusa.controller.UserController;
import com.virtusa.lpservlets.LpServlet;
public  class UserLogin {
	
	public static final Logger log = Logger.getLogger(UserLogin.class.getName());
	public static void main(String[] args) {
	log.info("Main Method Stared");
	UserLogin.loginMenu();
	}
	public static void loginMenu() {
		final Scanner sc=new Scanner(System.in);
		System.out.println("Enter User Id:");
		String userId=sc.next();
		System.out.println("Enter Password:");
		String password=sc.next();
		
		UserController controller=new UserController();
		controller.userAuthentication(userId, password);
		
	
	}
	
	public void invalidLogin() {
		
		System.out.println("Invalid Username or Password");
		loginMenu();
	}

}
