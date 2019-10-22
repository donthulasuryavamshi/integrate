package com.virtusa.lpservlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.virtusa.helper.FactoryDB;
import com.virtusa.model.AdminModel;
import com.virtusa.model.LpDetailsModel;
import com.virtusa.model.UpdateAdminModel;
import com.virtusa.model.ViewBatchDetailsModel;
import com.virtusa.service.AdminService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       AdminService adminService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
        this.adminService=FactoryDB.createAdminService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 HttpSession session = request.getSession();
		    String username = (String) session.getAttribute("username");
		    System.out.println(username);
		   String action=request.getParameter("action");
		   if(action.contentEquals("viewmyprofile")) {
			   List<AdminModel> adminModelList = adminService.retrieveAdminDetails(username);
			 System.out.println(adminModelList);
				request.setAttribute("adminModelList", adminModelList);
			     RequestDispatcher dispatcher=
							request.getRequestDispatcher("viewAdminProfile.jsp");
					dispatcher.forward(request,response);
		   }
		  // String action=request.getParameter("action");
			  if(action.contentEquals("registerlp")) {
				  RequestDispatcher dispatcher=request.getRequestDispatcher("registerLp.jsp");
				  dispatcher.forward(request, response);
			  }
		   if (action.contentEquals("loadform")) {

				RequestDispatcher dispatcher1 = request.getRequestDispatcher("UpdateProfile.jsp");
				dispatcher1.forward(request, response);

			}
		   
		   //HttpSession session = request.getSession();
			String userid = (String) session.getAttribute("username");


					
					if(action.contentEquals("updateProfile")) {
						RequestDispatcher dispatcher1 = request.getRequestDispatcher("UpdateProfile.jsp");

				        	String firstName=request.getParameter("firstName");
				        	String lastName=request.getParameter("lastName");
				        	String email=request.getParameter("email");
				        	String phoneNumber=request.getParameter("phoneNumber");
				        	String role=request.getParameter("role");
				        	String state=request.getParameter("state");
				        	String country=request.getParameter("country");
				        	String city=request.getParameter("city");
				        	
				        	UpdateAdminModel admindetailsModel=new UpdateAdminModel();
				        	admindetailsModel.setFirstName(firstName);
				        	admindetailsModel.setLastName(lastName);
				        	admindetailsModel.setEmail(email);
				        	admindetailsModel.setPhoneNumber(phoneNumber);
				        	admindetailsModel.setRole(role);
				        	admindetailsModel.setCity(city);
				        	admindetailsModel.setState(state);
				        	admindetailsModel.setCountry(country);
				        	admindetailsModel.setUserId(userid);
				        	
				        	System.out.println();
				    

						//dispatcher1.forward(request, response);
					
						try {
							boolean result = adminService.storeAdminService(admindetailsModel);
							request.setAttribute("result", result);
							if(result==true) {
								
								RequestDispatcher dispatcherupdated=request.getRequestDispatcher("detailsUpdated.jsp");
								dispatcherupdated.forward(request, response);
								}
							else {
								
								RequestDispatcher dispatchernotupdated=request.getRequestDispatcher("detailsNotUpdated.jsp");
								dispatchernotupdated.forward(request, response);}
								
							}
							
						catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        	
					}
					if(action.contentEquals("viewlpdetails")) {
						List<LpDetailsModel> lpdetailsModelList = new ArrayList<LpDetailsModel>();

						lpdetailsModelList = adminService.lpViewLpDetails();
						System.out.println(lpdetailsModelList.get(0).getFirstName());

						request.setAttribute("lpdetailsModelList", lpdetailsModelList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("viewlpdetails.jsp");
						dispatcher.forward(request, response);

					}
					if(action.contentEquals("viewbatchdetails")) {
						List<ViewBatchDetailsModel> batchdetailsModelList = new ArrayList<ViewBatchDetailsModel>();

						batchdetailsModelList = adminService.getBatchDetails();
						System.out.println(batchdetailsModelList.get(0).getBatchName());

						request.setAttribute("batchdetailsModelList", batchdetailsModelList);
						RequestDispatcher dispatcher = request.getRequestDispatcher("ViewBatchDetails.jsp");
						dispatcher.forward(request, response);
						
					}
					
			   
		   }
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

