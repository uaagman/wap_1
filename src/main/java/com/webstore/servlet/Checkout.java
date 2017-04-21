package com.webstore.servlet;

import com.webstore.model.Factory;
import com.webstore.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(request.getSession().getAttribute("LoggedUser") == null){
            response.sendRedirect(getServletContext().getContextPath()+"/login");
        }else{
            User logged = null;
            List<User> users = new ArrayList<>(Factory.getUsers().values());
            for(User u : users){
                if(u.getUsername().equals(request.getSession().getAttribute("LoggedUser"))){
                    logged = u;
                    break;
                }
            }
            if(logged != null) {
                if (logged.getBillingAddress() == null) {
                    //to get billing address
                } else if (logged.getShippingAddress() == null) {
                    //to get shipping address
                } else {
                    //to checkout details display page
                }
            } else{
                response.sendRedirect(getServletContext().getContextPath()+"/logout");
            }
        }
    }
}
