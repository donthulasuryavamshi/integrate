package com.virtusa.MentorServlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.websocket.Session;

import com.virtusa.helper.FactoryMentorService;
import com.virtusa.model.MentorModel;
import com.virtusa.service.MentorService;
import com.virtusa.service.MentorServiceImpl;

/**
 * Servlet implementation class MentorServlet
 */
@WebServlet("/mentorprofileviewservlet")
public class MentorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MentorService mentorService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.mentorService = FactoryMentorService.createMentorService();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		  //  LpModel lpModel=new LpModel();
		  // String userId= lpModel.getId();
		    HttpSession session = request.getSession();
		    String userid = (String) session.getAttribute("userid");
		    System.out.println(userid);
		    
		    String action=request.getParameter("action");
			if(action.contentEquals("View")) {
			List<MentorModel> mentorModelList= mentorService.retrieveMentorDetails(userid);
			
		     request.setAttribute("mentorModelList", mentorModelList);
		     RequestDispatcher dispatcher=
						request.getRequestDispatcher("ViewMentorProfile.jsp");
				dispatcher.forward(request,response);
		     
			}
		
	}

}
