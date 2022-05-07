package com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.controller.servlet;

import com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.dao.ServiceDAO;
import com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.model.User;
import com.github.vasiljeu95.authandauthorizationwithfilterinjspservlet.model.UserRole;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.concurrent.atomic.AtomicReference;

@WebListener()
public class ContextListener implements ServletContextListener {
    private AtomicReference<ServiceDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        dao = new AtomicReference<>(new ServiceDAO());

        dao.get().add(new User(1, "Vlad", "1234", UserRole.ADMIN_ROLE));
        dao.get().add(new User(2, "Stepan", "4321", UserRole.USER_ROLE));

        final ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}
