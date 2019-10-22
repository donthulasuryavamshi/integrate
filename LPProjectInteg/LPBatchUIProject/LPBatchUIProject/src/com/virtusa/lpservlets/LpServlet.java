package com.virtusa.lpservlets;

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
import javax.websocket.Session;

import com.virtusa.helper.FactoryLpService;
import com.virtusa.model.LpModel;
import com.virtusa.service.LpService;
import com.virtusa.service.LpServiceImpl;

/**
 * Servlet implementation class LpServlet
 */
@WebServlet("/lpprofileviewservlet")
public class LpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LpService lpService=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		this.lpService = FactoryLpService.createLpService();
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
			List<LpModel> lpModelList= lpService.retrieveLpDetails(userid);
			
		     request.setAttribute("lpModelList", lpModelList);
		     RequestDispatcher dispatcher=
						request.getRequestDispatcher("ViewLpProfile.jsp");
				dispatcher.forward(request,response);
		     
			}
		
	}

}
