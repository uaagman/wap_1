package com.webstore.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ashok on 4/20/2017.
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 5588340024678664999L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
		response.sendRedirect(getServletContext().getContextPath()+"/");
	}
}
