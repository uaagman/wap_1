package com.webstore.servlet;

import com.webstore.model.Factory;
import com.webstore.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashok on 4/20/2017.
 */
public class Checkout extends HttpServlet {

	private static final long serialVersionUID = 76868510909228857L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("LoggedUser") == null) {
			response.sendRedirect(getServletContext().getContextPath() + "/login");
		} else {
			User logged = null;
			List<User> users = new ArrayList<>(Factory.getUsers().values());
			for (User u : users) {
				if (u.getUsername().equals(request.getSession().getAttribute("LoggedUser"))) {
					logged = u;
					break;
				}
			}
			if (logged != null) {
				if (logged.getBillingAddress() == null) {
					request.setAttribute("addType","billing");
					request.getRequestDispatcher("addAddress.jsp").forward(request,response);
					// to get billing address
				} else if (logged.getShippingAddress() == null) {
					request.setAttribute("addType","shipping");
					request.getRequestDispatcher("addAddress.jsp").forward(request,response);
					// to get shipping address
				} else {
					if(request.getSession().getAttribute("cartItems") != null){
						request.setAttribute("cartItems",request.getSession().getAttribute("cartItems"));
						request.getSession().removeAttribute("cartItems");
					}
					request.getRequestDispatcher("confirmation.jsp").forward(request,response);
					// to checkout details display page
				}
			} else {
				response.sendRedirect(getServletContext().getContextPath() + "/logout");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String a;
	}
}
