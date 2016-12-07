package net.etfbl.movies.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import net.etfbl.movies.bean.MovieBean;
import net.etfbl.movies.bean.UserBean;
import net.etfbl.movies.dao.UserDAO;
import net.etfbl.movies.model.User;
import net.etfbl.movies.util.Util;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/guest")
@MultipartConfig
public class GuestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GuestServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/header-guest.jsp");
		disp.include(request, response);
		HttpSession session = request.getSession();
		if ("logout".equals(action)) {
			UserBean userBean = (UserBean)session.getAttribute("isLogedIn");
			userBean.logout();
			disp = request.getRequestDispatcher("WEB-INF/guest.jsp");
			disp.include(request, response);
		} else if ("register".equals(action)){
			session.setAttribute("isLogedIn", new UserBean());
			disp = request.getRequestDispatcher("WEB-INF/register.jsp");
			disp.include(request, response);
		} else {
			disp = request.getRequestDispatcher("WEB-INF/guest.jsp");
			disp.include(request, response);
		}
		disp = request.getRequestDispatcher("WEB-INF/footer.jsp");
		disp.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		HttpSession session = request.getSession();
		if (name != null) {
			String oldPassword = request.getParameter("password-register-old");
			User user = new User();
			Part image = request.getPart("dataFile");
			String fileName = Util.getFileName(image);
			System.out.println("file name: " + fileName);
			String path = getServletContext().getRealPath(File.separator) + "user-images";
			System.out.println("file path: " + path);
			File location = new File(path);
			if(!location.exists()){
				location.mkdir();
			}
			if (fileName != null && !fileName.equals("")) {
				image.write(location + File.separator + fileName);
				user.setImagePath("user-images" + File.separator + fileName);
			} else {
				if (oldPassword != null && !oldPassword.equals("")) {
					user.setImagePath(((UserBean)session.getAttribute("isLogedIn")).getUser().getImagePath());
				} else {
					fileName = "resources/images/users/no-face.png";
					user.setImagePath(fileName);
				}
			}
			if (oldPassword != null && !oldPassword.equals("")) {
				setUser(request, user, name);
				user.setId(((UserBean)session.getAttribute("isLogedIn")).getUser().getId());
				UserDAO.updateUser(user);
				((UserBean)session.getAttribute("isLogedIn")).setUser(user);
				session.setAttribute("isLogedIn", ((UserBean)session.getAttribute("isLogedIn")));
				response.sendRedirect("home");
			} else {
				setUser(request, user, name);
				UserDAO.insertUser(user);
				response.sendRedirect("guest");
			}
		} else {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			UserBean userBean = new UserBean();
			if (userBean.login(username, password)) {
				session.setAttribute("isLogedIn", userBean);
				session.setAttribute("movieBean", new MovieBean());
				response.sendRedirect("home");
			} else {
				RequestDispatcher disp = request.getRequestDispatcher("WEB-INF/header-guest.jsp");
				disp.include(request, response);
				disp = request.getRequestDispatcher("WEB-INF/login-error-message.jsp");
				disp.include(request, response);
				disp = request.getRequestDispatcher("WEB-INF/footer.jsp");
				disp.include(request, response);
				response.setHeader("Refresh", "5; URL=/Movies/guest");
			}
		}
	}

	private void setUser (HttpServletRequest request, User user, String name) {
		String surname = request.getParameter("surname");
		String ucn = request.getParameter("ucn");
		String email = request.getParameter("email");
		String username = request.getParameter("username-register");
		String password = request.getParameter("password-register");
		user.setName(name);
		user.setSurname(surname);
		user.setUcn(ucn);
		user.setEmail(email);
		user.setUsername(username);
		user.setPasswordHash(Util.calculateMD5Hash(password));
		user.setUserType("gost");
	}
}
