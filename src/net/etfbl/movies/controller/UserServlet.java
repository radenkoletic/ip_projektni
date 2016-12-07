package net.etfbl.movies.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.etfbl.movies.bean.UserBean;
import net.etfbl.movies.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action != null && "activate".equals(action)) {
			int selectedUserId = Integer.parseInt(request.getParameter("id"));
			String userType = request.getParameter("type");
			UserBean userBean = (UserBean)request.getSession().getAttribute("isLogedIn");
			for (User u : userBean.getAllUsers()) {
				if (u.getId() == selectedUserId) {
					u.setUserType(userType);
					userBean.updateUserStatus(u);
				}
			}
		} else {
			RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/header-user.jsp");
			disp.include(request, response);
			if (action != null && "view".equals(action)) {
				int selectedUserId = Integer.parseInt(request.getParameter("id"));
				((UserBean)request.getSession().getAttribute("isLogedIn")).setSelectedUserId(selectedUserId);
				disp = request.getRequestDispatcher("WEB-INF/user.jsp");
				disp.include(request, response);
			} else if (action != null && "delete".equals(action)) {
				int selectedUserId = Integer.parseInt(request.getParameter("id"));
				UserBean userBean = (UserBean)request.getSession().getAttribute("isLogedIn");
				for (User u : userBean.getAllUsers()) {
					if (u.getId() == selectedUserId) {
						userBean.deleteUser(u);
						response.setHeader("Refresh", "0; URL=/Movies/users");
					}
				}
			} else {
				disp = request.getRequestDispatcher("WEB-INF/users.jsp");
				disp.include(request, response);
			}
			disp = request.getRequestDispatcher("WEB-INF/footer.jsp");
			disp.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
