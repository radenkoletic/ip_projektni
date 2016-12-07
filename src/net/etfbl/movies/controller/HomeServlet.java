package net.etfbl.movies.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.etfbl.movies.bean.MovieBean;


/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/home")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public HomeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/header-user.jsp");
		disp.include(request, response);
		if ("settings".equals(action)) {
			disp = request.getRequestDispatcher("WEB-INF/register.jsp");//same form as for registering
			disp.include(request, response);
		} else {
			String searchImdb = request.getParameter("search-imdb");
			if (searchImdb != null && !searchImdb.equals("")) {
				((MovieBean)request.getSession().getAttribute("movieBean")).setMovieList(searchImdb);
			} else {
				((MovieBean)request.getSession().getAttribute("movieBean")).setDefaultMovieList();
			}
			disp = request.getRequestDispatcher("WEB-INF/home.jsp");
			disp.include(request, response);
		}
		disp = request.getRequestDispatcher("WEB-INF/footer.jsp");
		disp.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
