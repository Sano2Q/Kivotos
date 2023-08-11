package student.controller;

import org.thymeleaf.context.Context;
import student.dao.ActivityDao;
import student.dao.ActivityDaoImpl;
import student.dao.ClubDao;
import student.dao.ClubDaoImpl;
import student.entity.Activity;
import student.entity.Club;
import student.util.ThUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateActivityServlet", value = "/UpdateActivityServlet")
public class UpdateActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        ActivityDao activityDao = new ActivityDaoImpl();
        ClubDao clubDao = new ClubDaoImpl();
        Activity activity = activityDao.selectById(id);
        activity.setClubName(clubDao.selectNameById(activity.getClub()));

        Context context = new Context();
        context.setVariable("activity",activity);
        ThUtil.print(context,response,"student/updateActivity.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
