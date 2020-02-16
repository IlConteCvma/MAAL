package weblogic;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import execption.UserException;
import logic.bean.StudentBean;
import logic.controller.LoginController;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	    if (request.getParameter("username") != null && request.getParameter("password") != null) {
	        	StudentBean sBean = new StudentBean();
	    		sBean.setUsername(request.getParameter("username")); 
	        	sBean.setPassword(request.getParameter("password"));
	        	LoginController logCtrl = new LoginController();
	        	try{
	        		logCtrl.login(sBean);
	        		request.getRequestDispatcher("prova.jsp").forward(request, response);
	        	}catch(SQLException | UserException e){
	        		response.setStatus(0);
	        	}
	    }
	}

}
