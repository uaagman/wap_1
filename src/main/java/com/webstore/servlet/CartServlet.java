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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("error") != null){
            request.setAttribute("error",request.getSession().getAttribute("error"));
            request.getSession().removeAttribute("error");
        }
        request.getRequestDispatcher("views/cart.jsp").forward(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer pro_id = Integer.parseInt(request.getParameter("pro_id"));
        Integer qty = Integer.valueOf(request.getParameter("qty"));
        if(qty == null){
            qty = 1;
        }
        List<Product> products = (List<Product>) Factory.getProducts().values();
        List<Cart> carts = (List<Cart>) request.getSession().getAttribute("cartItems");
        int count = 0;
        for (Cart c:carts){
            if(c.getProductId() == pro_id){
                count++;
            }
        }
        if(count == 0){
            for (Product p : products){
                if(p.getId().equals(pro_id)){
                    carts.add(new Cart(p.getId() , qty));
                }
            }
        } else {
            request.getSession().setAttribute("error","Product is already in cart");
        }

        request.getSession().setAttribute("cartItems",carts);
        response.sendRedirect(getServletContext().getContextPath()+"/myCart");
    }
}
