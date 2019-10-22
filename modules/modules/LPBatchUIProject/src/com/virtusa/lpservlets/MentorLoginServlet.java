package com.virtusa.lpservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.virtusa.helper.FactoryUserDAO;
import com.virtusa.helper.FactoryUserService;
import com.virtusa.model.UserModel;
import com.virtusa.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/mentorLoginServlet")
public class MentorLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserService userService2;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MentorLoginServlet() {
        super();
        // TODO Auto-generated constructor stub

		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//UserModel userModel=new UserModel();
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		//request.setAttribute(username, username);
		UserModel userModel=new UserModel();
		userModel.setUserId(username);
		userModel.setPassword(password);
		
		boolean userType=userService2.userAuthenticationService(userModel);
	
		
		if (userType==true) {
              
			 RequestDispatcher dispatcher=
						request.getRequestDispatcher("MentorMenu.jsp");
				dispatcher.forward(request,response);	
		
		}
	}

}
