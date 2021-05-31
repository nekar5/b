package com.mainpackage;

import com.mainpackage.dao.AdminDAOimpl;
import com.mainpackage.dao.GroupDAOimpl;
import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    private AtomicReference<AdminDAOimpl> adminDAO;
    private AtomicReference<GroupDAOimpl> groupDAO;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        adminDAO = new AtomicReference(new AdminDAOimpl());
        groupDAO = new AtomicReference(new GroupDAOimpl());
        final ServletContext servletContext
                = sce.getServletContext();
        servletContext.setAttribute("adminDAO", adminDAO);
        servletContext.setAttribute("groupDAO", groupDAO);
        servletContext.setAttribute("groups", groupDAO.get().getGroups());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        adminDAO = null;
        groupDAO = null;
    }
}
