package com.virtusa.lpservlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.virtusa.entities.Lp;
import com.virtusa.helper.FactoryLpService;
import com.virtusa.model.BatchModel;
import com.virtusa.model.CalendarModel;
import com.virtusa.model.LPModel;
import com.virtusa.model.UpdateLpDetailsModel;
import com.virtusa.model.UserModel;
import com.virtusa.service.LpService;
import com.virtusa.service.LpServiceImpl;
import com.virtusa.validation.UpdateLpDetailsModelValidator;

/**
 * Servlet implementation class LpServlet
 */
@WebServlet("/lpprofileviewservlet")
public class LpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	LpService lpService;

	public LpServlet() {
		super();
		// TODO Auto-generated constructor stub
		this.lpService = FactoryLpService.createLpService();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		String action = request.getParameter("action");

		if (action.contentEquals("view")) {

			List<LPModel> lpModelList = lpService.retrieveLpDetails(username);

			request.setAttribute("lpModelList", lpModelList);
			System.out.println(lpModelList);
			session.setAttribute("lpModelList", lpModelList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLpProfile.jsp");
			dispatcher.forward(request, response);
		}

		if (action.contentEquals("loadform")) {

			RequestDispatcher dispatcher1 = request.getRequestDispatcher("UpdateProfileForm.jsp");
			dispatcher1.forward(request, response);

		}
		if (action.contentEquals("viewbatchdetails")) {

			List<BatchModel> batchModelList;

			try {
				batchModelList = lpService.retrieveBatchDetails(username);
				System.out.println(batchModelList);
				request.setAttribute("batchModelList", batchModelList);
			} catch (ClassNotFoundException | SQLException e) {
				// Auto-generated
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("BatchDetails.jsp");
			dispatcher.forward(request, response);

		}

		if (action.contentEquals("viewcalendar")) {

			List<CalendarModel> calendarModelList;

			try {
				calendarModelList = lpService.retrieveCalendar(username);
				System.out.println(calendarModelList);
				request.setAttribute("calendarModelList", calendarModelList);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			RequestDispatcher dispatcher = request.getRequestDispatcher("CalendarView.jsp");
			dispatcher.forward(request, response);

		}

		if (action.contentEquals("logout")) {

			session.invalidate();
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String action = request.getParameter("action");
		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("username");


		if (action.contentEquals("updateProfile")) {
			
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("UpdateProfileForm.jsp");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String email = request.getParameter("email");
			String phoneNumber = request.getParameter("phoneNumber");
			String role = request.getParameter("role");
			String state = request.getParameter("state");
			String country = request.getParameter("country");
			String city = request.getParameter("city");

			UpdateLpDetailsModel detailsModel = new UpdateLpDetailsModel();
			detailsModel.setFirstName(firstName);
			detailsModel.setLastName(lastName);
			detailsModel.setEmail(email);
			detailsModel.setPhoneNumber(phoneNumber);
			detailsModel.setRole(role);
			detailsModel.setCity(city);
			detailsModel.setState(state);
			detailsModel.setCountry(country);
			detailsModel.setUserId(userid);
			
		
		

			/**

			
			UpdateLpDetailsModelValidator validator = new UpdateLpDetailsModelValidator();
			boolean validFirstName = validator.validString(firstName);
			boolean validLastName = validator.validString(lastName);
			boolean validEmail = validator.validEmail(email);
			boolean validPhoneNumber = validator.validString(phoneNumber);
			boolean emailExist = validator.emailExist(email);

			if (!validFirstName || !validLastName || !validEmail || !validPhoneNumber || emailExist) {

				if (!validFirstName) {
					request.setAttribute("firstnameerror", "First Name not valid");
				}
				if (!validLastName) {
					request.setAttribute("lastnameerror", "Last Name not valid");
				}
				if (!validEmail) {
					request.setAttribute("emailerror", "Email not valid");

				}
				if (!validPhoneNumber) {
					request.setAttribute("phonenumbererror", "Phone Numbernot valid");

				}
				if (emailExist) {
					request.setAttribute("emailexisterror", "Email already exist");

				}
				RequestDispatcher dispatcher = request.getRequestDispatcher("UpdateProfileForm.jsp");
				dispatcher.forward(request, response);

			}

			else {
**/
				
					boolean result = false;
					
						try {
							result = lpService.storeLpService(detailsModel);
						} catch (ClassNotFoundException | SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					request.setAttribute("result", result);
					if (result == true) {

						RequestDispatcher dispatcher11 = request.getRequestDispatcher("detailsUpdated.jsp");
						dispatcher11.forward(request, response);
					} else {

						RequestDispatcher dispatcher = request.getRequestDispatcher("detailsNotUpdated.jsp");
						dispatcher.forward(request, response);
					}
					
	 }
	}
		
	}

			
		
		
	
