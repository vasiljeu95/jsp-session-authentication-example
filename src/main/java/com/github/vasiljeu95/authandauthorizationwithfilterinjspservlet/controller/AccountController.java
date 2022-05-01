package com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/account")
public class AccountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response );
        } else if (action.equalsIgnoreCase("logout")) {
            HttpSession httpSession = request.getSession();
            httpSession.removeAttribute("username");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("123")) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", username);
            response.sendRedirect(getServletContext().getContextPath() + "/admin/adminListProducts.jsp");
        } else if (username.equalsIgnoreCase("user") && password.equalsIgnoreCase("123")) {
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("username", username);
            response.sendRedirect(getServletContext().getContextPath() + "/user/userListProducts.jsp");
        } else {
            request.setAttribute("message", "Account's Invalid");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
