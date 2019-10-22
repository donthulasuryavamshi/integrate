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
import com.virtusa.model.BatchDetailsModel;
import com.virtusa.model.LpDetailsModel;
import com.virtusa.model.MentorDetailsModel;
import com.virtusa.model.UpdateAdminModel;
import com.virtusa.model.VenueDetailsModel;
import com.virtusa.model.ViewBatchDetailsModel;
import com.virtusa.service.AdminService;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       AdminService adminService;
       String SuccessMessage = "";
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
		   //String action1=request.getServletPath();
		   if(action.contentEquals("viewmyprofile")) {
			   List<AdminModel> adminModelList = adminService.retrieveAdminDetails(username);
			 System.out.println(adminModelList);
				request.setAttribute("adminModelList", adminModelList);
			     RequestDispatcher dispatcher=
							request.getRequestDispatcher("viewAdminProfile.jsp");
					dispatcher.forward(request,response);
		   }
		  // String action=request.getParameter("action");
			  if(action.contentEquals("register")) {
				  RequestDispatcher dispatcher=request.getRequestDispatcher("reg.html");
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
						RequestDispatcher dispatcher = request.getRequestDispatcher("ViewLpProfile.jsp");
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
					
					if(action.contentEquals("/viewmentordetails")) {
						
						List<MentorDetailsModel> mentordetailsList = new ArrayList<MentorDetailsModel>();

						mentordetailsList = adminService.getMentorDetails();
					

						request.setAttribute("mentordetailsList", mentordetailsList);
						System.out.println("wsfse"+mentordetailsList);

						RequestDispatcher dispatcher = request.getRequestDispatcher("MentorsList.jsp");
						dispatcher.forward(request, response);
						
					}
					if(action.contentEquals("batchlist")) {
						List<BatchDetailsModel> batchdetailslist = new ArrayList<BatchDetailsModel>();
						List<MentorDetailsModel> mentordetailslist = new ArrayList<MentorDetailsModel>();

						mentordetailslist = adminService.getMentorDetails();
						batchdetailslist = adminService.getBatchDetails1();
					

						request.setAttribute("batchdetailsList", batchdetailslist);
						request.setAttribute("mentordetailsList", mentordetailslist);
						RequestDispatcher dispatcher = request.getRequestDispatcher("MentorsList.jsp");
						dispatcher.forward(request, response);
						
						
					}
					
					if(action.contentEquals("/updatebatch")) {
						int rowsupdated = 0;
						try {
							String mentroId = request.getParameter("mentorid");
							String batchId = request.getParameter("batchid");
							System.out.println(mentroId+"  "+ batchId);

							rowsupdated = adminService.updatedmentordetails(mentroId, batchId);

						} catch (Exception e) {
							e.printStackTrace();
						}
						if (rowsupdated > 0)
							SuccessMessage = "Batch Added Successfully";
						else
							SuccessMessage = "Batch Assigning Failed";

						request.setAttribute("SuccessMessage", SuccessMessage);
						response.sendRedirect("/MentorDetails/viewmentordetails");
					}
				
					
	if(action.contentEquals("/viewvenuedetails")) {
        
        
        //List<BatchDetailsModel> batchdetailslist = new ArrayList<BatchDetailsModel>();
        List<VenueDetailsModel> venuedetailsList = new ArrayList<VenueDetailsModel>();



        venuedetailsList = adminService.getVenueDetails();
        //batchdetailslist = venueservice.getBatchDetails();
        



        //request.setAttribute("batchdetailsList", batchdetailslist);
        request.setAttribute("venuedetailsList", venuedetailsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("venueindex.jsp");
        dispatcher.forward(request, response);
        
    }
    if(action.contentEquals("venuebatchlist")) {
        List<BatchDetailsModel> batchdetailslist = new ArrayList<BatchDetailsModel>();
        List<VenueDetailsModel> venuedetailsList = new ArrayList<VenueDetailsModel>();



        venuedetailsList = adminService.getVenueDetails();
        batchdetailslist = adminService.getBatchDetails2();
        


System.out.println("fesf"+batchdetailslist);
        request.setAttribute("batchdetailsList", batchdetailslist);
        request.setAttribute("venuedetailsList", venuedetailsList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("venueindex.jsp");
        dispatcher.forward(request, response);
    }
    
    if(action.contentEquals("/updatebatch")) {
        int rowsupdated = 0;
        try {
            String venueId = request.getParameter("venueId");
            String batchId = request.getParameter("batchId");
            
System.out.println(venueId + "  " + batchId);
            rowsupdated = adminService.updatedVenuedetails(venueId, batchId);
            
            



        } catch (Exception e) {
            e.printStackTrace();
        }
        if (rowsupdated > 0) {
            SuccessMessage = "Batch Added Successfully";
        } else {
            SuccessMessage = "Batch Assigning Failed";
        }



 



        request.setAttribute("SuccessMessage", SuccessMessage);
        response.sendRedirect("/Venue/venuelist");
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

