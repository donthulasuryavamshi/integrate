package com.virtusa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtusa.convertor.DateConvertor;
import com.virtusa.helper.FactoryAdminService;
import com.virtusa.helper.FactoryLpService;
import com.virtusa.model.LPRegistrationModel;
import com.virtusa.service.AdminService;
import com.virtusa.service.AdminService1;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/admincontroller")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AdminService1 adminService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Override
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	this.adminService = FactoryAdminService.createAdminService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action=request.getParameter("action");
		  if(action.contentEquals("registerlp")) {
			  RequestDispatcher dispatcher=request.getRequestDispatcher("registerLp.jsp");
			  dispatcher.forward(request, response);
				
			
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action=request.getParameter("action");
		
		
       if(action.contentEquals("register")) {
		LPRegistrationModel lpRegistrationModel = new LPRegistrationModel();
		
	
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("registerLp.jsp");
			String lpId = request.getParameter("lpId");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			int phoneNumber =Integer.parseInt(request.getParameter("phoneNumber"));
			String email = request.getParameter("email");
			String role = request.getParameter("role");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String city = request.getParameter("city");

			lpRegistrationModel.setLpId(lpId);
			lpRegistrationModel.setFirstName(firstName);
			lpRegistrationModel.setLastName(lastName);
			lpRegistrationModel.setPhoneNumber(phoneNumber);
			lpRegistrationModel.setEmail(email);
			lpRegistrationModel.setDesignation(role);
			lpRegistrationModel.setCity(city);
			lpRegistrationModel.setState(state);
			lpRegistrationModel.setCountry(country);

					boolean result = false;
					try {
						result = adminService.createLpRegistration(lpRegistrationModel);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("result", result);
					if (result == true) {

						RequestDispatcher dispatcher11 = request.getRequestDispatcher("registrationsuccess.jsp");
						dispatcher11.forward(request, response);
					} else {

						RequestDispatcher dispatcher = request.getRequestDispatcher("registrationfail.jsp");
						dispatcher.forward(request, response);
					}

				}
       /**String lpId = request.getParameter("lpId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastname");
		String dob=request.getParameter("dob");
		LocalDate DoB = DateConvertor.dateFormat(dob);
		String email = request.getParameter("email");
		int phoneNumber = Integer.parseInt(request.getParameter("phonenumber"));
		String role= request.getParameter("role");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		
		lpRegistrationModel.setLpId(lpId);
		lpRegistrationModel.setFirstName(firstName);
		lpRegistrationModel.setLastName(lastName);
		lpRegistrationModel.setDob(DoB);
		lpRegistrationModel.setEmail(email);
		lpRegistrationModel.setPhoneNumber(phoneNumber);
		lpRegistrationModel.setDesignation(role);
		lpRegistrationModel.setCity(city);
		lpRegistrationModel.setState(state);
		lpRegistrationModel.setCountry(country);
		
		System.out.println(lpRegistrationModel);
		 RequestDispatcher dispatcher1=
  				request.getRequestDispatcher("registerLp.jsp");
			dispatcher1.forward(request,response);
			try {
				String outcome=adminService.createLpRegistration(lpRegistrationModel);
				
				if(outcome.contentEquals("success")) {
					 request.setAttribute("lpRegistrationModel",lpRegistrationModel);
					RequestDispatcher dispatcher=
    	    				request.getRequestDispatcher("registrationsuccess.jsp");
    			
       			// request.setAttribute("operation", "Below lp record Registration was Successfully");

       			dispatcher.forward(request,response);
				}else {
					
					 RequestDispatcher dispatcher=
     	    				request.getRequestDispatcher("registrationfail.jsp");
        			// request.setAttribute("operation", "Lp Registration Failed");

     	    		dispatcher.forward(request,response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		**/
       }
	}


