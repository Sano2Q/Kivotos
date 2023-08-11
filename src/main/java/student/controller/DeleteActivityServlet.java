package student.controller;

import student.dao.ActivityDao;
import student.dao.ActivityDaoImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteActivityServlet", value = "/DeleteActivityServlet")
public class DeleteActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        ActivityDao activityDao = new ActivityDaoImpl();
        activityDao.deleteActivity(id);

        response.sendRedirect("SelectAllActivityServlet?keyword=");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
