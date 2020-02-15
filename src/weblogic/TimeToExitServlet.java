package weblogic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import execption.LessonNotFoundException;
import execption.TimeException;
import logic.Session;
import logic.bean.StudentBean;
import logic.bean.TimeToExitBean;
import logic.controller.ViewTimeToExitController;

/**
 * Servlet implementation class TimeToExitServlet
 */
@WebServlet("/TimeToExitServlet")
public class TimeToExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TimeToExitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentBean sBean = new StudentBean();
		TimeToExitBean timeBean = new TimeToExitBean();
		ViewTimeToExitController useCaseController = new ViewTimeToExitController();
		sBean.setUsername(Session.getSession().getStudent().getUsername());

		// Passa il controllo alla nuova pagina
		try {
			timeBean = useCaseController.estimateTimeToExit();
			request.getSession().setAttribute("timeBean", timeBean);
			response.setStatus(1);
			request.getRequestDispatcher("timeToExit.jsp").forward(request, response);
		} catch (TimeException e) {
			response.setStatus(0);
		} catch (LessonNotFoundException e) {
			response.setStatus(0);
		}

	}

}
