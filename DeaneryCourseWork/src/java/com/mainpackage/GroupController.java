package com.mainpackage;

import com.mainpackage.dao.GroupDAOimpl;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.GroupService;

public class GroupController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html; charset=UTF-8");
            request.setCharacterEncoding("UTF-8");
            String name = request.getParameter("name");
            GroupService gs = new GroupService();
            ServletContext servletContext = getServletContext();
            AtomicReference<GroupDAOimpl> groupDAO = (AtomicReference<GroupDAOimpl>)servletContext.getAttribute("groupDAO");
            request.setAttribute("group", gs.service(name, groupDAO));
            String path = "/WEB-INF/jsp/group.jsp";
            RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
            requestDispatcher.forward(request, response);
    }

}