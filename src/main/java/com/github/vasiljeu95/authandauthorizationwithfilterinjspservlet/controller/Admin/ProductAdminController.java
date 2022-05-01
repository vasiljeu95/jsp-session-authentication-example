package com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.controller.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/admin/product")
public class ProductAdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("adminListProducts.jsp").forward(request, response);

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
    }
}
