package student.controller;

import student.dao.ActivityDao;
import student.dao.ActivityDaoImpl;
import student.entity.Activity;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ToAddActivityServlet", value = "/ToAddActivityServlet")
public class ToAddActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String aname = request.getParameter("aname");
        String asynopsis = request.getParameter("asynopsis");
        Date starttime = Date.valueOf(request.getParameter("starttime"));
        Date endtime = Date.valueOf(request.getParameter("endtime"));
        String place = request.getParameter("place");
        int anumber = Integer.parseInt(request.getParameter("anumber"));
        int club = Integer.parseInt(request.getParameter("club"));
        String aleader = request.getParameter("aleader");

        Activity activity = new Activity(null, aname, asynopsis, starttime, endtime, place, anumber, club, aleader);
        ActivityDao activityDao = new ActivityDaoImpl();
        activityDao.addActivity(activity);
        response.sendRedirect("SelectAllActivityServlet?keyword=");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
