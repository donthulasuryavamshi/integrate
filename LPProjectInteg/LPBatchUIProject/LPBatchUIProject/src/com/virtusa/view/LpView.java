package com.virtusa.view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.apache.log4j.Logger;
import com.virtusa.client.UserLogin;
import com.virtusa.controller.LpController;
import com.virtusa.dao.UserDaoImpl;
import com.virtusa.entities.TrainingCalendar;
import com.virtusa.exception.ValidationException;
import com.virtusa.model.CalendarModel;
import com.virtusa.model.LpModel;
import com.virtusa.model.UpdateLpDetailsModel;
import com.virtusa.model.UserModel;
import com.virtusa.validation.UpdateLpDetailsModelValidator;


public class LpView {
	public static final Logger log = Logger.getLogger(UserDaoImpl.class.getName());
   
	

	public static void lpMenu(UserModel userModel) {
	

		System.out.println("*Welocome to LP HomePage**");
		System.out.println("====================================");
		System.out.println("Please Select any one option");
		System.out.println("1.My Profile.");
		System.out.println("2.View Training Calender");
		System.out.println("3.View Training Status");
		System.out.println("4.LP Batch");
		System.out.println("5.Logout");
		System.out.println("====================================");

		Scanner scanner=new Scanner(System.in);
		String userId=userModel.getUserId();
		System.out.println(userId);
		try {
			int option = scanner.nextInt();
			switch (option) {

			case 1:
				lpProfile(userId);
				break;
				
			case 2:LpController lpController=new LpController();
			lpController.viewTraningCalendar();
				break;
				
			case 3:
				break;
				
			case 4:
				break;

			case 5:
				System.out.println("You Have Successfully LoggedOut.Thank You For Visit");
				UserLogin userLogin = new UserLogin();
				userLogin.loginMenu();

				break;
			default:
				System.out.println("**Please Enter Valid Option**");

			}
		} catch (Exception e) {
			System.out.println("Oops! We have detected an issue.");
			System.out.println("Please try again.");
		}
	}

	public static void lpProfile(String userId) {
		System.out.println("My Profile");
		System.out.println("-------------------------------------");
		System.out.println("Please Select any one option");
		System.out.println("1.View Your Profile");
		System.out.println("2.Edit Your Profile");
		System.out.println("3:Enter '3' to go back to LP Menu");
		System.out.println("-------------------------------------");
		Scanner scanner = new Scanner(System.in);

		try {
			int profileOption = scanner.nextInt();

			switch (profileOption) {
			case 1:
				LpController lpController = new LpController();
				lpController.retrieveLpDetails(userId);

				break;

			case 2:
				updateLpDetails(userId);

				break;

			case 3:
				//lpMenu(userModel);
				break;

			default:
				System.out.println("**Please Enter Valid Option**");
				LpView lpView = new LpView();
				lpProfile(userId);
				break;

			}

		} catch (Exception ex) {
			System.err.println("Oops! We have detected an issue.");
			System.err.println("Please try again.");
		}

	}
	
	

	public void viewLpDetails(List<LpModel> lpModel) {
		for(LpModel model:lpModel) {
		System.out.println("LP ID:" + model.getId());
		System.out.println("Full Name:" + model.getFullName());
		System.out.println("Contact Details=>" + model.getContactDetails());
		System.out.println("Role:" + model.getRole());
		System.out.println("Address:" + model.getAddress());
		log.info("Viewed User Details");

		
		//lpProfile(userId);
		}
	}
	
	
	public void showCalendar(TrainingCalendar models){
		
		System.out.println("=========Training Calendar========");
		System.out.println("BATCH ID:"+( models).getBatchId());
		System.out.println("DATE:"+( models).getDate());
		System.out.println("TOPIC:"+(models).getTopic());
		
	}

	public static void updateLpDetails(String userId) throws ClassNotFoundException, SQLException {

		UpdateLpDetailsModelValidator validator = new UpdateLpDetailsModelValidator();

		Scanner scanner = new Scanner(System.in);

		System.out.print("Enter FirstName:");
		String firstName = scanner.next();

		boolean validfirstName = validator.validString(firstName);
		if (!validfirstName)
			try {
				throw new ValidationException("[!ERROR:Invalid First Name]");
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
				lpProfile(userId);
			}

		System.out.print("Last LastName:");
		String lastName = scanner.next();

		boolean validLastName = validator.validString(lastName);
		if (!validLastName)
			try {
				throw new ValidationException("[!ERROR:Invalid Last Name]");
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
				lpProfile(userId);
			}

		System.out.print("Enter Email:");
		String email = scanner.next();

		boolean validemail = validator.validEmail(email);
		if (!validemail)
			try {
				throw new ValidationException("[!ERRORInvalid Email]");
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
				lpProfile(userId);
			}

		System.out.print("Enter PhoneNumber:");
		String phoneNumber = scanner.next();

		boolean validphonenumber = validator.validNumber(phoneNumber);
		if (!validphonenumber)
			try {
				throw new ValidationException("[!ERRORInvalid Phone Number]");
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
				lpProfile(userId);
			}

		System.out.print("Destination:");
		String role = scanner.next();

		boolean validdestination = validator.validString(role);
		if (!validdestination)
			try {
				throw new ValidationException("[!ERRORInvalid Role]");
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
				lpProfile(userId);
			}

		System.out.print("City:");
		String city = scanner.next();

		boolean validcity = validator.validString(role);
		if (!validcity)
			try {
				throw new ValidationException("[!ERRORInvalid City]");
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
				lpProfile(userId);
			}

		System.out.print("State:");
		String state = scanner.next();

		boolean validstate = validator.validString(state);
		if (!validstate)
			try {
				throw new ValidationException("[!ERRORInvalid State]");
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
				lpProfile(userId);
			}

		System.out.print("Country:");
		String country = scanner.next();

		boolean validcountry = validator.validString(country);
		if (!validcountry)
			try {
				throw new ValidationException("[!ERRORInvalid Country]");
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
				lpProfile(userId);
			}

		UpdateLpDetailsModel updateLpDetailsView = new UpdateLpDetailsModel();
		updateLpDetailsView.setFirstName(firstName);
		updateLpDetailsView.setLastName(lastName);
		updateLpDetailsView.setEmail(email);
		updateLpDetailsView.setPhoneNumber(phoneNumber);
		updateLpDetailsView.setRole(role);
		updateLpDetailsView.setCity(city);
		updateLpDetailsView.setState(state);
		updateLpDetailsView.setCountry(country);

		LpController lpcontroller = new LpController();
		lpcontroller.storeLp(updateLpDetailsView);

	}

	public void lpProfileMenu(String userId) {

		Scanner sc = new Scanner(System.in);
		System.out.println("enter 0 to go back to My Profile");
		int s = sc.nextInt();
		if (s == 0) {

			lpProfile(userId);
		} else {

			System.out.println("Please Provide Valid Option");
		}

	}

	public void storeSuccess(String userId) {
		LpView lpView = new LpView();
		System.out.println("Details Updated Successfully");
		lpView.lpProfileMenu(userId);

		log.info("Details updated by User");

	}

	public void storeUnsuccess(String userId) {

		System.out.println("Details Not Updated");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter 0 to go back to My Profile");
		LpView lpView = new LpView();
		lpView.lpProfileMenu(userId);
		log.info("Tried to update the details but failed");

	}
	
	public void showTraningCalendar(List<CalendarModel> models) {
		for(CalendarModel model:models) {
			System.out.println("Batch Id:  "+model.getBatchId()+"   Date:  "+model.getDate()+"  Topic:  "+model.getTopic());
			

		}
		
	}
	
	
	

}
