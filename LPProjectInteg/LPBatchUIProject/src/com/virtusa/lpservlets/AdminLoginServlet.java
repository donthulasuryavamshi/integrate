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
import com.virtusa.helper.FactoryUserService2;
import com.virtusa.model.UserModel;
import com.virtusa.service.UserService;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/adminloginservlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserService userService1;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
		this.userService1 = FactoryUserService2.createUserService();

		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");

		HttpSession session = request.getSession();
		session.setAttribute("username", username);
	
		/** request.setAttribute(username, password);
		UserController uc = new UserController();
		boolean userType=uc.userAuthentication(username, password);**/
		
		UserModel userModel=new UserModel();
		userModel.setUserId(username);
		userModel.setPassword(password);
		
		boolean userType=userService1.userAuthenticationService(userModel);
	
		
		if (userType==true) {
              
			 RequestDispatcher dispatcher=
						request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request,response);
		
		
		
	}}

}
