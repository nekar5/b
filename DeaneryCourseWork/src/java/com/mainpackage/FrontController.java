package com.mainpackage;

import com.mainpackage.classes.Group;
import com.mainpackage.classes.Student;
import com.mainpackage.dao.AdminDAOimpl;
import com.mainpackage.dao.GroupDAOimpl;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import services.AddGroupService;
import services.AddStudentService;
import services.AdminService;
import services.DeleteGroupService;
import services.DeleteStudentService;
import services.SearchService;
//<% request.getSession().setAttribute("action","addgroup"); %>

@WebServlet(name = "FrontController")
public class FrontController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String log = (String) request.getParameter("enter");
        if ("Увійти як адміністратор".equals(log) || request.getSession().getAttribute("login") == null) {
            login(request, response);
        }

        String action = (String) request.getSession().getAttribute("action");
        try {

            if (action == null) {
                String path = request.getContextPath() + "/menu.jsp";
                response.sendRedirect(path);
            }

            switch (action) {
                case "search":
                    search(request, response);
                    break;
                case "addgroup":
                    addGroup(request, response);
                    break;
                case "addstudent":
                    addStudent(request, response);
                    break;
                case "deletegroup":
                    deleteGroup(request, response);
                    break;
                case "deletestudent":
                    deleteStudent(request, response);
                    break;
                default:
                    String path = request.getContextPath() + "/menu.jsp";
                    response.sendRedirect(path);
                    break;
            }
        } catch (RuntimeException ex) {
            //error(request, response, ex.getMessage());
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        request.getSession().invalidate();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        String button = request.getParameter("enter");
        ServletContext sc = getServletContext();
        AdminService as = new AdminService();
        AtomicReference<AdminDAOimpl> adminDAO = (AtomicReference<AdminDAOimpl>) sc.getAttribute("adminDAO");
        HttpSession session = request.getSession();
        session.setAttribute("login", login);
        as.service(login, password, button, adminDAO);
        String path = request.getContextPath() + "/menu.jsp";
        response.sendRedirect(path);
    }

    protected void search(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext servletContext = getServletContext();
        String text = request.getParameter("text");
        String type = request.getParameter("search");
        SearchService ss = new SearchService();
        AtomicReference<GroupDAOimpl> groupDAO = (AtomicReference<GroupDAOimpl>) servletContext.getAttribute("groupDAO");
        request.setAttribute("serchResult", ss.service(text, type, groupDAO));
        String path = "/WEB-INF/jsp/searchResult.jsp";
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    protected void addGroup(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Group group = new Group(request.getParameter("name"));
        AddGroupService ags = new AddGroupService();
        ServletContext servletContext = getServletContext();
        AtomicReference<GroupDAOimpl> groupDAO = (AtomicReference<GroupDAOimpl>) servletContext.getAttribute("groupDAO");
        ags.service(group, groupDAO);
        String path = request.getContextPath() + "/menu.jsp";
        response.sendRedirect(path);
    }

    protected void addStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        Student student = new Student(request.getParameter("name"), request.getParameter("surname"), Double.parseDouble(request.getParameter("rating")));
        String groupName = request.getParameter("groupName");
        AddStudentService ass = new AddStudentService();
        ServletContext servletContext = getServletContext();
        AtomicReference<GroupDAOimpl> groupDAO = (AtomicReference<GroupDAOimpl>) servletContext.getAttribute("groupDAO");
        ass.service(groupName, student, groupDAO);
        String path = request.getContextPath() + "/menu.jsp";
        response.sendRedirect(path);
    }

    protected void deleteGroup(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        DeleteGroupService dgs = new DeleteGroupService();
        ServletContext servletContext = getServletContext();
        AtomicReference<GroupDAOimpl> groupDAO = (AtomicReference<GroupDAOimpl>) servletContext.getAttribute("groupDAO");
        dgs.service(name, groupDAO);
        String path = request.getContextPath() + "/menu.jsp";
        response.sendRedirect(path);
    }

    protected void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int ind = Integer.parseInt(request.getParameter("index"));
        String groupName = request.getParameter("groupName");
        DeleteStudentService dss = new DeleteStudentService();
        ServletContext servletContext = getServletContext();
        AtomicReference<GroupDAOimpl> groupDAO = (AtomicReference<GroupDAOimpl>) servletContext.getAttribute("groupDAO");
        dss.service(groupName, ind, groupDAO);
        String path = request.getContextPath() + "/menu.jsp";
        response.sendRedirect(path);
    }

    /*
    protected void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().invalidate();
        String path = request.getContextPath() + "/index.html";
        response.sendRedirect(path);
    }
     */
    protected void error(HttpServletRequest request, HttpServletResponse response, String message) throws ServletException, IOException {
        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/jsp/error.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
