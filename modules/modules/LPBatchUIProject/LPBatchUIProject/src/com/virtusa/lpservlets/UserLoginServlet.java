package com.virtusa.lpservlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.client.UserLogin;
import com.virtusa.controller.UserController;
import com.virtusa.helper.FactoryUserDAO;
import com.virtusa.helper.FactoryUserService;
import com.virtusa.model.UserModel;
import com.virtusa.service.UserService;
import com.virtusa.view.LpView;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/userLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserService userService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
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
		
		//request.setAttribute(username, username);
		UserController uc = new UserController();
		boolean userType=uc.userAuthentication(username,password);
		HttpSession session = request.getSession();
		session.setAttribute("userid", username);
		//boolean userType = userService.userAuthenticationService();
		if (userType == true) {
              
			 RequestDispatcher dispatcher=
						request.getRequestDispatcher("LpMenu.jsp");
				dispatcher.forward(request,response);
		
		
		
	}}

}
