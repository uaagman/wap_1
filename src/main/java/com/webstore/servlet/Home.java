package com.webstore.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webstore.model.Factory;
import com.webstore.model.Product;

@WebServlet("")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Product> productsMap;

    public Home() {
        super();
        productsMap = Factory.getProducts();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("products", productsMap.values());
		request.getRequestDispatcher("views/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
