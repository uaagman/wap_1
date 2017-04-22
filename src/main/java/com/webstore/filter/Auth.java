package com.webstore.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Auth implements Filter {

    public Auth() {
        
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;

		HttpSession session = httpServletRequest.getSession();
		String loggedUser = (String) session.getAttribute("LoggedUser");
		if (loggedUser!=null) {
			chain.doFilter(httpServletRequest, httpServletResponse);
		}else {
			httpServletResponse.sendRedirect("login");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
