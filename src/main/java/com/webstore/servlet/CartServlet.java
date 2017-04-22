package com.webstore.servlet;

import com.webstore.model.Cart;
import com.webstore.model.Factory;
import com.webstore.model.Product;

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
public class CartServlet extends HttpServlet {

	private static final long serialVersionUID = 8073647668757449295L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("error") != null) {
			request.setAttribute("error", request.getSession().getAttribute("error"));
			request.getSession().removeAttribute("error");
		}
		request.setAttribute("title","My Cart");
		request.getRequestDispatcher("views/cart.jsp").forward(request, response);
	}

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer pro_id = Integer.parseInt(request.getParameter("pro_id"));
		Integer qty;
		if (request.getParameter("qty").equals("")) {
			qty = 1;
		} else {
			qty = Integer.valueOf(request.getParameter("qty"));
		}
		List<Product> products = new ArrayList<Product>(Factory.getProducts().values());
		List<Cart> carts = (List<Cart>) request.getSession().getAttribute("cartItems");
		int count = 0;
		if (carts != null) {
			for (Cart c : carts) {
				if (c.getProductId() == pro_id) {
					count++;
				}
			}
		} else {
			carts = new ArrayList<>();
		}
		if (count == 0) {
			for (Product p : products) {
				if (p.getId().equals(pro_id)) {
					carts.add(new Cart(p.getId(), qty));
				}
			}
		} else {
			request.getSession().setAttribute("error", "Product is already in cart");
		}

		request.getSession().setAttribute("cartItems", carts);
		response.sendRedirect(getServletContext().getContextPath() + "/myCart");
	}
}
