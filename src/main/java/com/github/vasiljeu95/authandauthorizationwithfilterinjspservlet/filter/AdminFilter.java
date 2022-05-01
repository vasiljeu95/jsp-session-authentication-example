package com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AdminFilter")
public class AdminFilter implements Filter {

    public void init(FilterConfig config) {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();

        //TODO
        if (httpSession.getAttribute("username") != null) {
            chain.doFilter(request, response);
        } else {
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
