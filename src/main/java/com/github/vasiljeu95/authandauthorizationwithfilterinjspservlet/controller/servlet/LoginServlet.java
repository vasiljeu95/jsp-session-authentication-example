package com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.controller.servlet;

import com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.dao.ServiceDAO;
import com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.model.UserRole;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static java.util.Objects.nonNull;

@WebServlet("LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        final String login = req.getParameter("login");
//        final String password = req.getParameter("password");
//
//        final AtomicReference<ServiceDAO> dao = (AtomicReference<ServiceDAO>) req.getServletContext().getAttribute("dao");
//        final HttpSession session = req.getSession();
//
//        //Logged user.
//        if (nonNull(session) && nonNull(session.getAttribute("login")) && nonNull(session.getAttribute("password"))) {
//            final UserRole userRole = (UserRole) session.getAttribute("role");
//
////            moveToMenu(req, resp, userRole);
//        } else if (dao.get().userIsExist(login, password)) {
//            final UserRole userRole = dao.get().getRoleByLoginPassword(login, password);
//
//            req.getSession().setAttribute("password", password);
//            req.getSession().setAttribute("login", login);
//            req.getSession().setAttribute("role", userRole);
//
////            moveToMenu(req, res, userRole);
//        } else {
//            moveToMenu(req, res, UserRole.UNKNOWN_ROLE);
//        }
        req.getRequestDispatcher("user.jsp").forward(req, resp);
    }
}
