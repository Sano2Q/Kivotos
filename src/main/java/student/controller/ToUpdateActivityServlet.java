package student.controller;

import student.dao.ActivityDao;
import student.dao.ActivityDaoImpl;
import student.entity.Activity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ToUpdateActivityServlet", value = "/ToUpdateActivityServlet")
public class ToUpdateActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        int aid = Integer.parseInt(request.getParameter("aid"));
        String aname = request.getParameter("aname");
        String asynopsis = request.getParameter("asynopsis");
        Date starttime = Date.valueOf(request.getParameter("starttime"));
        Date endtime = Date.valueOf(request.getParameter("endtime"));
        String place = request.getParameter("place");
        int anumber = Integer.parseInt(request.getParameter("anumber"));
        int club = 1;
        String aleader = request.getParameter("aleader");

        Activity activity = new Activity(aid, aname, asynopsis, starttime, endtime, place, anumber, club, aleader);
        ActivityDao activityDao = new ActivityDaoImpl();
        activityDao.updateActivity(activity);
        response.sendRedirect("SelectAllActivityServlet?keyword=");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
