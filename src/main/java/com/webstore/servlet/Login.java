package com.webstore.servlet;

import com.webstore.model.Factory;
import com.webstore.model.User;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("LoggedUser") != null) {
			response.sendRedirect(getServletContext().getContextPath()+"/home");
		} else {
			if (request.getSession().getAttribute("error") != null) {
				request.setAttribute("error", request.getSession().getAttribute("error"));
				request.getSession().removeAttribute("error");
			}
			request.getRequestDispatcher("views/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("userName");
		String password = request.getParameter("userPassword");
		Map<String,User> users = Factory.getUsers();
		if (users.containsKey(username) && users.get(username).getPassword().equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("LoggedUser", username);

			for (Cookie c : request.getCookies()) {
				if (c.getName().equals("LoggedUser")) {
					c.setMaxAge(0);
					c.setValue("");
					c.setPath("/");
					response.addCookie(c);
					break;
				}
			}
			if ("on".equals(request.getParameter("remember"))) {
				Cookie cookie = new Cookie("LoggedUser", username);
				cookie.setMaxAge(30*24*60*60);
				response.addCookie(cookie);
			}
			if(request.getParameter("referer").equals(request.getHeader("referer")) || request.getParameter("referer").equals("")){
                response.sendRedirect(getServletContext().getContextPath()+"/home");
            }else{
                response.sendRedirect(request.getParameter("referer"));
            }
		} else {
			request.getSession().setAttribute("error", "Username / password incorrect");
			response.sendRedirect(getServletContext().getContextPath()+"/login");
		}
	}

}
