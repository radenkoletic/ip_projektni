package net.etfbl.movies.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.etfbl.movies.bean.GenreBean;

/**
 * Servlet implementation class GenreServlet
 */
@WebServlet("/genres")
public class GenreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GenreServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/header-user.jsp");
		disp.include(request, response);
		if (action != null && "add".equals(action)) {
			
		} else if (action != null && "delete".equals(action)) {
			int genreID = Integer.parseInt(request.getParameter("id"));
			GenreBean genreBean = (GenreBean) request.getSession().getAttribute("genreBean");
			genreBean.deleteGenre(genreID);
			response.setHeader("Refresh", "0; URL=/Movies/genres");
		} else {
			GenreBean genreBean = new GenreBean();
			request.getSession().setAttribute("genreBean", genreBean);
			disp = request.getRequestDispatcher("WEB-INF/genres.jsp");
			disp.include(request, response);
		}
		disp = request.getRequestDispatcher("WEB-INF/footer.jsp");
		disp.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
