package com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.servlet.filter;

import com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.dao.ServiceDAO;
import com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.model.UserRole;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");

        @SuppressWarnings("unchecked")
        final AtomicReference<ServiceDAO> dao = (AtomicReference<ServiceDAO>) req.getServletContext().getAttribute("dao");
        final HttpSession session = req.getSession();

        //Logged user.
        if (nonNull(session) && nonNull(session.getAttribute("login")) && nonNull(session.getAttribute("password"))) {
            final UserRole userRole = (UserRole) session.getAttribute("role");

            moveToMenu(req, res, userRole);
        } else if (dao.get().userIsExist(login, password)) {
            final UserRole userRole = dao.get().getRoleByLoginPassword(login, password);

            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("role", userRole);

            moveToMenu(req, res, userRole);
        } else {
            moveToMenu(req, res, UserRole.UNKNOWN_ROLE);
        }
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'user' move to user menu.
     */
    private void moveToMenu(final HttpServletRequest req, final HttpServletResponse res, final UserRole userRole) throws ServletException, IOException {

        if (userRole.equals(UserRole.ADMIN_ROLE)) {
            req.getRequestDispatcher("admin.jsp").forward(req, res);
        } else if (userRole.equals(UserRole.USER_ROLE)) {
            req.getRequestDispatcher("user.jsp").forward(req, res);
        } else {
            req.getRequestDispatcher("index.jsp").forward(req, res);
        }
    }

    public void destroy() {
    }
}
