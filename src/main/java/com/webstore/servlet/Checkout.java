package com.webstore.servlet;

import com.webstore.model.BillingAddress;
import com.webstore.model.Factory;
import com.webstore.model.ShippingAddress;
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
    User logged = new User();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("LoggedUser") == null) {
			response.sendRedirect(getServletContext().getContextPath() + "/login");
		} else {
			List<User> users = new ArrayList<>(Factory.getUsers().values());
			for (User u : users) {
				if (u.getUsername().equals(request.getSession().getAttribute("LoggedUser"))) {
					logged.setUsername(u.getUsername());
					logged.setPassword(u.getPassword());
					break;
				}
			}
			if (logged != null) {
                System.out.println(logged);
                if (logged.getBillingAddress() == null) {
				    request.setAttribute("title","Add Billing Address");
					request.setAttribute("addType","billing");
					request.getRequestDispatcher("views/address.jsp").forward(request,response);
					// to get billing address
				} else if (logged.getShippingAddress() == null) {
                    request.setAttribute("title","Add Shipping Address");
					request.setAttribute("addType","shipping");
					request.getRequestDispatcher("views/address.jsp").forward(request,response);
					// to get shipping address
				} else {
					if(request.getSession().getAttribute("cartItems") != null){
						request.setAttribute("cartItems",request.getSession().getAttribute("cartItems"));
						request.getSession().removeAttribute("cartItems");
					}
					request.getRequestDispatcher("views/confirmation.jsp").forward(request,response);
					// to checkout details display page
				}
			} else {
				response.sendRedirect(getServletContext().getContextPath() + "/logout");
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = new ArrayList<>(Factory.getUsers().values());
		for( User user: users){
			if(user.getUsername().equals(req.getSession().getAttribute("LoggedUser"))){
				logged.setUsername(user.getUsername());
				logged.setPassword(user.getPassword());
                break;
			}
		}
		if(req.getParameter("addType").equals("billing")){
			BillingAddress billingAddress = new BillingAddress(req.getParameter("street"),req.getParameter("city"),req.getParameter("state"),req.getParameter("zip"),req.getParameter("phone"));
			if(logged != null){
				logged.setBillingAddress(billingAddress);
			}

		}else {
			ShippingAddress shippingAddress = new ShippingAddress(req.getParameter("street"),req.getParameter("city"),req.getParameter("state"),req.getParameter("zip"),req.getParameter("phone"),req.getParameter("name"));
			if(logged != null){
				logged.setShippingAddress(shippingAddress);
			}
		}
        resp.sendRedirect(getServletContext().getContextPath()+"/checkout");
	}
}
