package com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.filter;

import com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.model.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "UserFilter")
public class UserFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession httpSession = httpServletRequest.getSession();

        //TODO
        if (httpSession.getAttribute("username") != null
                && httpSession.getAttribute("role").equals(UserRole.USER_ROLE.getValue())) {
            
            chain.doFilter(request, response);
        } else {
            httpServletRequest.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
